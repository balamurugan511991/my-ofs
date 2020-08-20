package com.order.fulfillment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.fulfillment.dto.FailedOrder;

@Repository
public interface FailedOrderRepository extends CrudRepository<FailedOrder, Integer>{

}
