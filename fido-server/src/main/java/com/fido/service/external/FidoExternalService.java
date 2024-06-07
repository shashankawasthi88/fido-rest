package com.fido.service.external;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fido.model.Device;
import com.fido.model.Location;
import com.fido.model.User;
import com.fido.service.internal.UserService;
import com.fido.wsclient.OpenAPIV4Locator;
import com.fido.wsclient.OpenAPIV4Soap;

@Service
public class FidoExternalService {

	OpenAPIV4Soap openAPIV4Soap;

	private final ObjectMapper objectMapper;

	private static final String state = "state";

	private static final String userID = "userID";

	private static final String id = "id";

	private static final String google = "Google";

	private static final String en = "EN";
	
	private double timezone = 5.50;

	@Autowired
	private UserService userService;

	@Autowired
	public FidoExternalService() {
		super();

		this.objectMapper = new ObjectMapper();
		OpenAPIV4Locator locator = new OpenAPIV4Locator();
		try {
			openAPIV4Soap = locator.getOpenAPIV4Soap();

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Creates user with first device
	 * 
	 * @param user
	 * @return
	 * @throws RemoteException 
	 * @throws IOException
	 */
	public User createUserandDevice(User user) throws IOException {

		if (!user.getDevices().iterator().hasNext()) {
			throw new RemoteException("No device data, can't create user on remote");

		}
		Device device = user.getDevices().iterator().next();

		String response = openAPIV4Soap.userRegister(device.getImei(), user.getEmail(), "1234",
				user.getUserPhoneNo(), device.getDeviceName(), 0);

		System.out.println("Response from the server for registration" + response);
		
			
		
		JsonNode rootNode = objectMapper.readTree(response);
		
		JsonNode stateNode = rootNode.path(state);

		if (!stateNode.isMissingNode()) {
			String state = stateNode.asText();
			// Act accordingly based on the value of "state"
			if ("0".equals(state)) {
				// Handle state "0"
				System.out.println("State is 0, taking appropriate action.");
				// login to get the User ID
				response = openAPIV4Soap.login(user.getEmail(), "1234" , 0);
				System.out.println("Response from the server for login" + response);

				rootNode = objectMapper.readTree(response);
				System.out.println("root node" +rootNode);
				JsonNode nodeUserID = rootNode.path("userInfo").path(userID);
				System.out.println("user id node" +nodeUserID);
				if (nodeUserID.isMissingNode()) {
					System.out.println("Response from the server for login" + response+ "User id is missing");
					throw new RemoteException("Could not login user on remote");
				}
				// user.setId(userID.asLong());

				user.setUserExternalId(nodeUserID.asLong());

				// get device list to get the device ID
				response = openAPIV4Soap.getDeviceList(nodeUserID.asInt(), 0, google, en);
				
				System.out.println("Response from the server for get device list" + response);

				rootNode = objectMapper.readTree(response);

				JsonNode arrNode = rootNode.path("arr");

				// Extract the id of the first element in the array
				if (arrNode.isArray() && arrNode.size() > 0) {
					JsonNode firstElement = arrNode.get(0);
					Long deviceId = firstElement.path(id).asLong();

					device.setDeviceExternalId(deviceId);

				} else {
					
					System.out.println("Response from the server for get device list" + response + "Could not fetch device list");
					throw new RemoteException("Could not fetch device list on remote");
				}

			} else {
				
				System.out.println("Response from the server for registration" + response + "the state is not 0");
				throw new RemoteException("Could not create User on remote");
			}
		} else {
			System.out.println("Response from the server for registration" + response+ "There is no state object");
			throw new RemoteException("Could not create User on remote");
		}
		
		return user;
	}

	/**
	 * Add device to an existing user
	 * @param device
	 * @return
	 * @throws IOException
	 */
	public Device addDevice(Device device) throws IOException {

		User user = userService.getUser(device.getUserId());

		String response = openAPIV4Soap.addDevice(device.getImei(), device.getDeviceName(), 0,
				device.getDevicePhoneNo(), (int) user.getUserExternalId(), 0);
		System.out.println("Response from the add device call" + response);

		JsonNode rootNode = objectMapper.readTree(response);
		JsonNode stateNode = rootNode.path(state);

		if (!stateNode.isMissingNode()) {
			String state = stateNode.asText();
			if ("0".equals(state)) {
				
				// Device added successfully, get the device ID
				
				response = openAPIV4Soap.getDeviceList((int)user.getUserExternalId(), 0, google, en);
				System.out.println("Response from the get device list call" + response);
				rootNode = objectMapper.readTree(response);
				JsonNode arrNode = rootNode.path("arr");
				
				System.out.println("Array of devices" + arrNode);
				// Iterate through the array to find the matching 'sn'
	            if (arrNode.isArray()) {
	                for (JsonNode element : arrNode) {
	                    String elementSn = element.path("sn").asText();
	                    if (device.getImei().equals(elementSn)) {
	                    	
	                    	System.out.println("Found the newley registered device in the device list array, adding its external ID ");
	                    	
	                    	device.setDeviceExternalId(element.path(id).asLong());
	  
	                    }
	                }
	            }
	            else 
	            {
	            	throw new RemoteException("Device registration passed, but device array is empty in device list");
	            	
	            }
			}
			else if ("1002".equals(state))
			{
				System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device registration failed");
			}
			else if ("1008".equals(state))
			{
				System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI already registered");
			}
			else if ("1007".equals(state))
			{
				System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI does not exist");
			}
		}
		if (device.getDeviceExternalId()== null)
		{
			throw new RemoteException("Can not extract external ID for the device");
		}
		return device;
	}
	
	
	/**
	 * Get location data from the remote
	 * @param device
	 * @return
	 * @throws IOException 
	 */
	public Location getLocation (Device device) throws IOException
	{
		String response = openAPIV4Soap.getTracking(device.getDeviceExternalId().intValue(), timezone, google, en);
		
		JsonNode rootNode = objectMapper.readTree(response);

        if ("0".equals(rootNode.path(state).asText())) {
            // Extract latitude and longitude
            Double latitude = rootNode.path("latitude").asDouble();
            Double longitude = rootNode.path("longitude").asDouble();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            
            Date timestamp= new Date();
			try {
				timestamp = dateFormat.parse((rootNode.path("deviceUtcDate").asText()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            Location location = new Location();
            
            location.setImei(device.getImei());
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            location.setTimestamp(timestamp);
            
            return location;
            
            
        }
        else {
        	throw new RemoteException("Could not fetch the location");
        }
	}
	
	
	/**
	 * Delete the device from remote server - transfer to superior
	 * @param device
	 * @return
	 * @throws IOException 
	 */
	public boolean deleteDevice (long extDeviceId, long extUserId) throws IOException
	{
		try {
			String response = openAPIV4Soap.transferToSuperior((int) extDeviceId, (int)extUserId, en);
			
			JsonNode rootNode = objectMapper.readTree(response);

	        if ("0".equals(rootNode.path(state).asText())) {
	        	
	        	System.out.println("Device successfully deleted from remote");
	        	return true;
	        }
	        else 
	        {
	        	System.out.println("Device could not be deleted from remote");
	        	
	        	throw new RemoteException("Could not delte the device from remote server");
	        }
			
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new RemoteException("Could not delte the device from remote server");
		}
	}

}
