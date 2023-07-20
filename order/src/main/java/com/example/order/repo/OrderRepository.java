package com.example.order.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
