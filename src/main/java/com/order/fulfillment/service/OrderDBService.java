package com.order.fulfillment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.fulfillment.dto.PackageOrder;
import com.order.fulfillment.repository.OrderRepository;

@Service
public class OrderDBService {

	private final Logger logger = LogManager.getLogger(OrderDBService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	public String save(String order) {
		logger.info("saving order to db");
		ObjectMapper om = new ObjectMapper();
		try {
			PackageOrder orderBean = om.readValue(order, PackageOrder.class);
			orderRepository.save(orderBean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		logger.info("successfully saved");
		return "successfully saved";
	}
	
	
}
