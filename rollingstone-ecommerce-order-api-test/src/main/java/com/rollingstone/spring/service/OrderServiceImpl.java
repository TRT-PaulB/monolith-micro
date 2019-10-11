package com.rollingstone.spring.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
import com.rollingstone.spring.model.OrderLineItem;
import com.rollingstone.spring.model.ROOrder;
import com.rollingstone.spring.model.ROrderLineItem;

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

	public ROOrder getOrder(Long orderId) {
		
		logger.info("Kaka 1");
		Optional<Order> optinoalOrder =  orderDao.findById(orderId);
		logger.info("Kaka 2");

		Order order = optinoalOrder.get();
		logger.info("Kaka 3");
		ROOrder roOder = new ROOrder(); 
		logger.info("Kaka 4");
		roOder.setId(order.getId());
		roOder.setAccountName(order.getAccount().getAccountNumber());
		roOder.setAccountNumber(order.getAccount().getAccountNumber());
		roOder.setBillingCity(order.getBillingAddress().getCity());
		roOder.setBillingHouseNumber(order.getBillingAddress().getHouseNumber());
		roOder.setBillingState(order.getBillingAddress().getState());
		roOder.setBillingStreetAddress(order.getBillingAddress().getState());
		roOder.setBillingStreetAddress(order.getBillingAddress().getStreetAddress());
		roOder.setBillingZipCode(order.getBillingAddress().getZipCode());
		
		roOder.setShippingCity(order.getShippingAddress().getCity());
		roOder.setShippingHouseNumber(order.getShippingAddress().getHouseNumber());
		roOder.setShippingState(order.getShippingAddress().getState());
		roOder.setShippingStreetAddress(order.getShippingAddress().getStreetAddress());
		roOder.setShippingZipCode(order.getShippingAddress().getZipCode());
		
		roOder.setUserName(order.getUser().getUserName());
		roOder.setFirstName(order.getUser().getFirstName());
		roOder.setLastName(order.getUser().getLastName());
		roOder.setSex(order.getUser().getSex());
		logger.info("Kaka 5");
		roOder.setOrderDate(order.getOrderDate());
		roOder.setOrderNumber(order.getOrderNumber());
		roOder.setOrderTotal(order.getOrderTotal());
		roOder.setOrderTrackingNumber(order.getOrderTrackingNumber());
		logger.info("Kaka 6");
		Set<OrderLineItem> orderItemsFromDB = order.getOrderItems();
		
		Set<ROrderLineItem> orderItems = new HashSet<ROrderLineItem>();
		logger.info("Kaka 7");
		/*for (OrderLineItem orderItemDB : orderItemsFromDB) {
			ROrderLineItem orderItem = new ROrderLineItem();
			logger.info("Kaka 7.1");

			orderItem.setId(orderItemDB.getId());
			orderItem.setProductCode(new Long(orderItemDB.getProductId()).toString());
			orderItem.setQuantity(orderItemDB.getQuantityOrdered());
			orderItem.setUnitOfMeasurement(orderItemDB.getUom());
			orderItem.setUnitPrice(orderItemDB.getUnitPrice());
			logger.info("Kaka 7.2");


			orderItems.add(orderItem);
		}
		
		logger.info("Kaka 8");
		roOder.setOrderItems(orderItems);*/
		
		return roOder;
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
