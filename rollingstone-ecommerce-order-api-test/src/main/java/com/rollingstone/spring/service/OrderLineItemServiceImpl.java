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

import com.rollingstone.spring.dao.OrderLineItemDaoRepository;
import com.rollingstone.spring.model.OrderLineItem;

@Service
public class OrderLineItemServiceImpl implements OrderLineItemService {

	  final static Logger logger = LoggerFactory.getLogger(OrderLineItemServiceImpl.class);

   @Autowired
   private OrderLineItemDaoRepository orderLineItemDao;  
  
   @Override
   public OrderLineItem save(OrderLineItem order) {
      return orderLineItemDao.save(order);
   }

   @Override
   public Optional<OrderLineItem> get(long id) {
      return orderLineItemDao.findById(id);
   }

   @Override
   public Page<OrderLineItem> getOrderLineItemsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
	   return orderLineItemDao.findAll(pageable);
   }

   @Override
   public void update(long id, OrderLineItem order) {
	   orderLineItemDao.save(order);
   }

   
   @Override
   public void delete(long id) {
	   orderLineItemDao.deleteById(id);
   }

}
