package com.fido.wsclient;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import com.fido.model.Device;
import com.fido.model.User;
import com.fido.service.external.FidoExternalService;

public class TestSOAPService {

	public static void main(String[] args) throws IOException {
		
		
		/*OpenAPIV4Locator locator = new OpenAPIV4Locator();
		
		try {
			OpenAPIV4Soap openAPIV4Soap = locator.getOpenAPIV4Soap();
			String response = openAPIV4Soap.login("shashank1", "1234", 0);
			System.out.println("Response from SOAP :" + response);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
 catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		
		FidoExternalService externalService = new FidoExternalService();
		
		User user = new User();
		
		
		user.setEmail("shashankawasthi90@gmail.com");
		user.setPassword("1234");
		user.setUserPhoneNo("9953956465");
		
		Device device = new Device();
		device.setDeviceName("Name");
		device.setImei("1234");
		Set<Device> devices = new HashSet<Device>();
		devices.add(device);
		user.setDevices(devices);
		user = externalService.createUserandDevice(user);
		System.out.println("User ID"+ user.getId()+ " Device ID :" + user.getDevices().iterator().next().getDeviceExternalId());
	}

}
