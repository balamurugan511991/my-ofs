package com.order.fulfillment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.order.fulfillment.controller.FulfillmentController;

@SpringBootTest
class OrderFulfillmentServiceApplicationTests {

	@Autowired
	FulfillmentController fulfillmentController;
	
	@Test
	void contextLoads() {
		assertThat(fulfillmentController).isNotNull();
	}
	

}
