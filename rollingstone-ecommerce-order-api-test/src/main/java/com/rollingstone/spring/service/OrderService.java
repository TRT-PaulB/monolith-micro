package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Order;
import com.rollingstone.spring.model.ROOrder;

public interface OrderService {

   Order save(Order order);
   Optional<Order> get(long id);
   Page<Order> getOrdersByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Order order);
   void delete(long id);
   ROOrder getOrder(Long id);
}
