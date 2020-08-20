package com.order.fulfillment.receiver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.order.fulfillment.service.ExternalService;
import com.order.fulfillment.service.OrderDBService;

@Service
public class OrderReceiver {

	private final Logger logger = LogManager.getLogger(OrderReceiver.class);
	
	@Autowired
	OrderDBService orderDBService;
	
	@Autowired
	ExternalService externalService;
	
	@JmsListener(destination = "OrderTransactionQueue")
	public void orderReceive(String order) {
		
		logger.info("Received from queue:{}",order);
		orderDBService.save(order);
		externalService.externalCall(order);
		
		
	}
	
	
}
