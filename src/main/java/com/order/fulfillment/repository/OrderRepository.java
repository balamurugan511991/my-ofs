package com.order.fulfillment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.fulfillment.dto.PackageOrder;

@Repository
public interface OrderRepository extends  CrudRepository<PackageOrder,Integer>{

}
