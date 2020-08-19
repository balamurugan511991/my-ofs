package com.order.fulfillment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FulfillmentController {

	@GetMapping("/")
	public String home() {
		return "Order Fulfillment is up...!!!";
	}
	
	
}
