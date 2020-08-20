package com.order.fulfillment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class ExternalService {
	
	private final Logger logger = LogManager.getLogger(ExternalService.class);
	
	@Autowired
	OrderDBService orderDBService;
	
	@CircuitBreaker(name = "default",fallbackMethod = "handleCBFailure")
	@Retry(name = "default",fallbackMethod = "handleREFailure")
	public void externalCall(String order) {
		logger.info("inside external API Call");
		RestTemplate rt = new RestTemplate();
		rt.getForObject("invalidURI", String.class);
	}
	
	public void handleREFailure(String order, Exception e) {
		
			logger.error("Retrying API Call handle failure...!!!");
			orderDBService.saveFailure(order);
	}
	
	public void handleCBFailure(String order, CallNotPermittedException e) {
		
			logger.error("Circuit Breaker Triggered...!!!");
			orderDBService.saveFailure(order);
	}

}
