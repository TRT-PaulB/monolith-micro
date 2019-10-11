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

import com.rollingstone.spring.dao.DeliveryDaoRepository;
import com.rollingstone.spring.model.Delivery;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	  final static Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);

   @Autowired
   private DeliveryDaoRepository deliveryDao;  
  
   @Override
   public Delivery save(Delivery delivery) {
      return deliveryDao.save(delivery);
   }

   @Override
   public Optional<Delivery> get(long id) {
	   logger.info("Delivery Id Received :"+id);
	   
	   Delivery delivery = deliveryDao.findById(id).get();
	   if (delivery == null) {
		   logger.info("Delivery Is Null :");
	   }
	   
      return deliveryDao.findById(id);
   }

   @Override
   public Page<Delivery> getDeliverysByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
	   return deliveryDao.findAll(pageable);
   }

   @Override
   public void update(long id, Delivery delivery) {
      deliveryDao.save(delivery);
   }

   
   @Override
   public void delete(long id) {
      deliveryDao.deleteById(id);
   }

}
