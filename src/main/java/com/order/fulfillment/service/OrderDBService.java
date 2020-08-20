package com.order.fulfillment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.fulfillment.dto.FailedOrder;
import com.order.fulfillment.dto.PackageOrder;
import com.order.fulfillment.repository.FailedOrderRepository;
import com.order.fulfillment.repository.OrderRepository;

@Service
public class OrderDBService {

	private final Logger logger = LogManager.getLogger(OrderDBService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	FailedOrderRepository failedOrderRepository;
	
	public String save(String order) {
		logger.info("saving order to db");
		ObjectMapper om = new ObjectMapper();
		try {
			PackageOrder orderBean = om.readValue(order, PackageOrder.class);
			orderRepository.save(orderBean);
			logger.info("successfully saved");
			return "successfully saved";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error while saving";
		}
	}
	
	
	public void saveFailure(String order) {
		logger.info("saving failed order to db");
		ObjectMapper om = new ObjectMapper();
		try {
			FailedOrder orderBean = om.readValue(order, FailedOrder.class);
			failedOrderRepository.save(orderBean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info("successfully saved failed order");
	}
	
}
