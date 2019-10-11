package com.rollingstone.spring.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.OrderDaoRepository;
import com.rollingstone.spring.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	  final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

   @Autowired
   private OrderDaoRepository orderDao;  
  
   @Override
   public Order save(Order order) {
      return orderDao.save(order);
   }

   @Override
   public Optional<Order> get(long id) {
      return orderDao.findById(id);
   }

   @Override
   public Page<Order> getOrdersByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("orderNumber").descending());
	   return orderDao.findAll(pageable);
   }

   @Override
   public void update(long id, Order order) {
      orderDao.save(order);
   }

   
   @Override
   public void delete(long id) {
      orderDao.deleteById(id);
   }

}
