package com.fido;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fido.service.external.FidoExternalService;

@Component
public class ScheduledExternalCall {
	
	
	@Autowired
	FidoExternalService externalServuce;
	
	
	//@Scheduled(fixedRate = 3600000) // 3600000 milliseconds = 1 hour
	//@Scheduled(fixedRate = 5000)
	//@Scheduled(fixedRate = 7200000) // 3600000 milliseconds = 1 hour
	public void getDistanceAndTimeAggregates()
	{
		try {
			externalServuce.getActivityDetails();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Caught exception while fetching aggregate details");
			e.printStackTrace();
			
		}
	}

}
