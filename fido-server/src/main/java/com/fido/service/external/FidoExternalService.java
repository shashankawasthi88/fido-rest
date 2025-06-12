package com.fido.service.external;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fido.model.AdditionalProperty;
import com.fido.model.Device;
import com.fido.model.HistoricalLocation;
import com.fido.model.Location;
import com.fido.model.LocationCoordinate;
import com.fido.model.User;
import com.fido.service.internal.DeviceService;
import com.fido.service.internal.UserService;
import com.fido.util.DogWalkingDistanceCalculator;
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

	private static final String lastCommunication = "lastCommunication";

	private static final String latitude = "latitude";

	private static final String longitude = "longitude";

	private static final String battery = "Battery";

	@Autowired
	private UserService userService;

	@Autowired
	private DeviceService deviceService;

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

		String response = openAPIV4Soap.userRegister(device.getImei(), user.getEmail(), "1234", user.getUserPhoneNo(),
				device.getDeviceName(), 0);

		System.out.println("Response from the server for registration" + response);

		JsonNode rootNode = objectMapper.readTree(response);

		JsonNode stateNode = rootNode.path(state);

		if (!stateNode.isMissingNode()) {
			String state = stateNode.asText();
			// Act accordingly based on the value of "state"
			if ("0".equals(state)) {
				// Handle state "0"
				// System.out.println("State is 0, taking appropriate action.");
				// login to get the User ID
				response = openAPIV4Soap.login(user.getEmail(), "1234", 0);
				// System.out.println("Response from the server for login" + response);

				rootNode = objectMapper.readTree(response);
				// System.out.println("root node" + rootNode);
				JsonNode nodeUserID = rootNode.path("userInfo").path(userID);
				// System.out.println("user id node" + nodeUserID);
				if (nodeUserID.isMissingNode()) {
					// System.out.println("Response from the server for login" + response + "User id
					// is missing");
					throw new RemoteException("Could not login user on remote");
				}
				// user.setId(userID.asLong());

				user.setUserExternalId(nodeUserID.asLong());

				// get device list to get the device ID
				response = openAPIV4Soap.getDeviceList(nodeUserID.asInt(), 0, google, en);

				// System.out.println("Response from the server for get device list" +
				// response);

				rootNode = objectMapper.readTree(response);

				JsonNode arrNode = rootNode.path("arr");

				// Extract the id of the first element in the array
				if (arrNode.isArray() && arrNode.size() > 0) {
					JsonNode firstElement = arrNode.get(0);
					Long deviceId = firstElement.path(id).asLong();

					device.setDeviceExternalId(deviceId);

				} else {

					// System.out.println(
					// "Response from the server for get device list" + response + "Could not fetch
					// device list");
					throw new RemoteException("Could not fetch device list on remote");
				}

			} else if ("1008".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI already registered");
			} else if ("1007".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI is invalid");
			} else if ("1006".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Email is already registered");
			} else {

				// System.out.println("Response from the server for registration " + response +
				// "the state is not 0");
				throw new RemoteException("Could not create User on remote");
			}
		} else {
			// System.out.println("Response from the server for registration" + response +
			// "There is no state object");
			throw new RemoteException("Could not create User on remote");
		}

		return user;
	}

	/**
	 * Add device to an existing user
	 * 
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

				response = openAPIV4Soap.getDeviceList((int) user.getUserExternalId(), 0, google, en);
				// System.out.println("Response from the get device list call" + response);
				rootNode = objectMapper.readTree(response);
				JsonNode arrNode = rootNode.path("arr");

				// System.out.println("Array of devices" + arrNode);
				// Iterate through the array to find the matching 'sn'
				if (arrNode.isArray()) {
					for (JsonNode element : arrNode) {
						String elementSn = element.path("sn").asText();
						if (device.getImei().equals(elementSn)) {

							// System.out.println(
							// "Found the newley registered device in the device list array, adding its
							// external ID ");

							device.setDeviceExternalId(element.path(id).asLong());

						}
					}
				} else {
					throw new RemoteException("Device registration passed, but device array is empty in device list");

				}
			} else if ("1002".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device registration failed");
			} else if ("1008".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI already registered");
			} else if ("1007".equals(state)) {
				// System.out.println("registrtation failed with" + state);
				throw new RemoteException("Device IMEI does not exist");
			}
		}
		if (device.getDeviceExternalId() == null) {
			throw new RemoteException("Can not extract external ID for the device");
		}
		return device;
	}

	/**
	 * Get location data from the remote
	 * 
	 * @param device
	 * @return
	 * @throws IOException
	 */
	public Location getLocation(Device device) throws IOException {
		String response = openAPIV4Soap.getTracking(device.getDeviceExternalId().intValue(), timezone, google, en);

		// System.out.println("Response from the get tracking call" + response);

		JsonNode rootNode = objectMapper.readTree(response);

		if ("0".equals(rootNode.path(state).asText())) {
			// Extract latitude and longitude
			Double lt = rootNode.path(latitude).asDouble();
			Double lo = rootNode.path(longitude).asDouble();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

			Double bttry = rootNode.path(battery).asDouble();

			// TODO Update the distance logic

			// Get distance
			// Double dist = rootNode.path(distance).asDouble()/1000;

			Double dist = this.getDistanceDetailsfromHistory(device, null);
			double distInKm = Math.floor((dist / 1000) * 100) / 100.0;

			Date timestamp = new Date();
			Long millis = null;
			try {
				timestamp = dateFormat.parse((rootNode.path(lastCommunication).asText()));
				millis = timestamp.getTime();
			} catch (ParseException e) {
				// System.out.println("Issue in parsing date in get tracking call");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Location location = new Location();

			location.setImei(device.getImei());
			location.setLatitude(lt);
			location.setLongitude(lo);
			location.setTimestamp(timestamp);
			location.setLongTimeStamp(millis);
			// Setting total distance in the additional properties
			AdditionalProperty additionalProperty = new AdditionalProperty();
			additionalProperty.setKey("Daily Distance");
			additionalProperty.setValue(distInKm + " km");
			List<AdditionalProperty> additionalProperties = new ArrayList<AdditionalProperty>();
			additionalProperties.add(additionalProperty);
			location.setAdditionalProperties(additionalProperties);
			location.setBatteryPercentage(bttry);
			return location;

		} else {
			// System.out.println("Response from the get tracking call is not state 0 :" +
			// response);
			throw new RemoteException("Could not fetch the location");
		}
	}

	/**
	 * Delete the device from remote server - transfer to superior
	 * 
	 * @param device
	 * @return
	 * @throws IOException
	 */
	public boolean deleteDevice(long extDeviceId, long extUserId) throws IOException {
		try {
			String response = openAPIV4Soap.transferToSuperior((int) extDeviceId, (int) extUserId, en);

			JsonNode rootNode = objectMapper.readTree(response);

			if ("0".equals(rootNode.path(state).asText())) {

				// System.out.println("Device successfully deleted from remote");
				return true;
			} else {
				// System.out.println("Device could not be deleted from remote");

				throw new RemoteException("Could not delte the device from remote server");
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new RemoteException("Could not delte the device from remote server");
		}
	}

	/**
	 * Fetch activity details of the device in every few hours
	 * 
	 * @throws IOException
	 */
	public void getActivityDetails() throws IOException {

		// System.out.println("getActivityDetails : This is running at a constant
		// rate");

		Calendar calendar = Calendar.getInstance();

		List<Device> devices = this.deviceService.getDevices();
		if (devices == null || devices.isEmpty()) {
			// System.out.println("getActivityDetails : No devices found to fetch the
			// details for");
			return;
		}
		for (Device device : devices) {
			double aggregateDistance = 0.0;
			double aggregateTime = 0.0;
			try {

				// System.out.println(device.getDeviceExternalId().intValue() + "0"
				// + String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":00" + timezone + "1"
				// + google + "10"
				// + en);

				String response = openAPIV4Soap.getDevicesHistory(device.getDeviceExternalId().intValue(), "0",
						String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":00", timezone, 1, google, 10, en);
				// System.out.println("Response for get History call for external Device ID :"
				// + device.getDeviceExternalId() + " :" + response);

				JsonNode rootNode = objectMapper.readTree(response);
				// System.out.println("Response for get History call for external Device ID :" +
				// device.getDeviceExternalId() + " :" + response);
				if ("0".equals(rootNode.path(state).asText())) {

					JsonNode extDevices = rootNode.get("devices");
					if (extDevices.isArray()) {
						for (JsonNode extDevice : extDevices) {
							aggregateDistance = extDevice.get("distance").asDouble();
							if (extDevice.get("devstop").asInt() == 1) {
								aggregateTime += extDevice.get("devsminutes").asDouble();
							}
						}
					}

					device.setDailyDistanceMovement(aggregateDistance);
					// Find activity period by subtracting current time in minutes with inactivity
					// period
					Double activityTime = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE)
							- aggregateTime;
					device.setDailyActivityTime(activityTime);
					// System.out.println("Distance from the external service for extDevice: "
					// + device.getDeviceExternalId() + " :" + aggregateDistance);

					// System.out.println("Activity time from the external service for extDevice: "
					// + device.getDeviceExternalId() + " :" + activityTime);

					// Update the device in the database
					this.deviceService.updateDevice(device);
				} else {
					// System.out.println(
					// "Count not find device history for external_deviceId :" +
					// device.getDeviceExternalId());

					continue;
				}

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	

	/**
	 * Helper function for timestamp conversion
	 * 
	 * @param timestampStr
	 * @return
	 */
	private LocalDateTime parseDeviceTimestamp(String timestampStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(timestampStr, formatter);
	}

	/**
	 * Get Location History
	 * 
	 * @param device
	 * @param date
	 * @return
	 * @throws IOException
	 */
	public HistoricalLocation getLocationHistory(Device device, LocalDate date) throws IOException {
		final int INITIAL_SAMPLE_COUNT = 2000;

		HistoricalLocation historicalLocation = new HistoricalLocation();
		
		historicalLocation.setDate(date);

		Double dist = this.getDistanceDetailsfromHistory(device, date);
		Double distInKm = Math.floor((dist / 1000) * 100) / 100.0;

		historicalLocation.setDistance(distInKm.toString()+ " km");
		List<LocationCoordinate> locationHistory = new ArrayList<>();
		historicalLocation.setCordinates(locationHistory);
		try {
			LocalDateTime startOfDay = date.atStartOfDay();
			LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");

			String formattedStart = startOfDay.format(formatter);
			String formattedEnd = endOfDay.format(formatter);

			int sampleCount = INITIAL_SAMPLE_COUNT;

			//System.out.println(device.getDeviceExternalId().intValue() + "----- " + formattedStart + "-----"
			//		+ formattedEnd + "----" + timezone + "-----" + sampleCount + "------" + google + "----" + "1"
			//		+ "----" + en);

			String response = openAPIV4Soap.getDevicesHistory(device.getDeviceExternalId().intValue(), formattedStart,
					formattedEnd, timezone, 0, google, sampleCount, en);
			//System.out.println("Response for get History call for external Device ID :" + device.getDeviceExternalId()
			//		+ " :" + response);

			JsonNode rootNode = objectMapper.readTree(response);

			if ("0".equals(rootNode.path(state).asText())) {
				JsonNode extDevices = rootNode.get("devices");

				if (extDevices.isArray() && extDevices.size() > 0) {

					for (JsonNode sample : extDevices) {
						double lat = sample.has("lat") ? sample.get("lat").asDouble() : 0.0;
						double lng = sample.has("lng") ? sample.get("lng").asDouble() : 0.0;
						String timestampStr = sample.has("date") ? sample.get("date").asText() : null;

						if (timestampStr != null) {
							LocalDateTime timestamp = parseDeviceTimestamp(timestampStr);

							// Convert LocalDateTime to java.util.Date
							Date date1 = Date.from(timestamp.atZone(ZoneId.systemDefault()).toInstant());
							LocationCoordinate coordinate = new LocationCoordinate();
							coordinate.setLatitude(lat);
							coordinate.setLongitude(lng);
							coordinate.setLongTimeStamp(date1.getTime());
							locationHistory.add(coordinate);
						}
					}

				} else {
					return historicalLocation; // No data
				}

			} else {
				throw new RuntimeException("External API failed for deviceId: " + device.getDeviceExternalId());
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			throw new IOException("Failed to fetch location history");
		}

		return historicalLocation;
	}

	/**
	 * Get distance details using the lat long coordinates from history data
	 * 
	 * @param device
	 * @return
	 * @throws IOException
	 */
	private double getDistanceDetailsfromHistory(Device device, LocalDate date) throws IOException {

		final int INITIAL_SAMPLE_COUNT = 2000;

		double totalDistance = 0.0;

		try {

			LocalDateTime endTime;
			LocalDateTime startOfDay;

			if (date == null) {
				// Case: date not provided — use today's start to now
				endTime = LocalDateTime.now();
				startOfDay = endTime.toLocalDate().atStartOfDay();
			} else {
				// Case: date provided — use full day from start to end of that date
				startOfDay = date.atStartOfDay();
				endTime = date.atTime(LocalTime.MAX);
			}

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");

			String formattedStart = startOfDay.format(formatter);
			String formattedEnd = endTime.format(formatter);

			int sampleCount = INITIAL_SAMPLE_COUNT;

			//System.out.println(device.getDeviceExternalId().intValue() + "----- " + formattedStart + "-----"
			//		+ formattedEnd + "----" + timezone + "-----" + sampleCount + "------" + google + "----" + "1"
			//		+ "----" + en);

				String response = openAPIV4Soap.getDevicesHistory(device.getDeviceExternalId().intValue(),
						formattedStart, formattedEnd, timezone, 0, google, sampleCount, en);
				// Step 2: Parse the JSON
				JsonNode rootNode = objectMapper.readTree(response);

				if ("0".equals(rootNode.path("state").asText())) {
					JsonNode extDevices = rootNode.get("devices");

					if (extDevices.isArray() && extDevices.size() > 1) {
						// Step 3: Build list of GPS points
						List<DogWalkingDistanceCalculator.GPSPoint> points = new ArrayList<>();
						for (JsonNode deviceNode : extDevices) {
							double lat = deviceNode.get("lat").asDouble();
							double lng = deviceNode.get("lng").asDouble();
							String timestamp = deviceNode.get("date").asText();
							points.add(new DogWalkingDistanceCalculator.GPSPoint(lat, lng, timestamp));
						}

						// Step 4: Calculate total distance. Remove any distance that has speed more
						// than 12KMP.
						totalDistance = DogWalkingDistanceCalculator.calculateTotalWalkedDistance(points, 12);
		
					} else {
						return 0.0;
					}
				} else {
					System.out.println("Invalid state for external_deviceId: " + device.getDeviceExternalId());
					return 0.0;
				}

				
			

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return totalDistance;
	}

}
