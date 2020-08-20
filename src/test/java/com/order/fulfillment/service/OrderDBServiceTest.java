package com.order.fulfillment.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.fulfillment.dto.PackageOrder;
import com.order.fulfillment.repository.FailedOrderRepository;
import com.order.fulfillment.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class OrderDBServiceTest {
	

	@Mock
	OrderRepository orderRepository;
	
	@Mock
	FailedOrderRepository failedOrderRepository;
	
	@InjectMocks
	OrderDBService orderDBService;
	
	
	@Test
	void save() throws Exception {

		Mockito.when(orderRepository.save(Mockito.any(PackageOrder.class))).thenReturn(null);
		
		PackageOrder packageOrder = new PackageOrder();
		packageOrder.setOrderCount(1);
		packageOrder.setOrderNumber("1234");
		ObjectMapper om = new ObjectMapper();
		
		String result = orderDBService.save(om.writeValueAsString(packageOrder));
		
		assertThat(result).isEqualTo("successfully saved");
		
	}
	
	@Test
	void saveWithException() throws Exception {

		String result = orderDBService.save("");
		
		assertThat(result).isEqualTo("Error while saving");
		
	}
	

}
