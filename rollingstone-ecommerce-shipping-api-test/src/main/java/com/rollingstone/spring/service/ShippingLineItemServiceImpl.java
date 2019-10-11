package com.rollingstone.spring.service;

import java.util.HashSet;
import java.util.List;
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

import com.rollingstone.spring.dao.ProductDaoRepository;
import com.rollingstone.spring.dao.ShippingLineItemDaoRepository;
import com.rollingstone.spring.model.Product;
import com.rollingstone.spring.model.ROShippingLineItem;
import com.rollingstone.spring.model.ShippingLineItem;

@Service
public class ShippingLineItemServiceImpl implements ShippingLineItemService {

	  final static Logger logger = LoggerFactory.getLogger(ShippingLineItemServiceImpl.class);

   @Autowired
   private ShippingLineItemDaoRepository shippingLineItemDao;  
   
   @Autowired
   private ProductDaoRepository productDao;  
  
   @Override
   public ShippingLineItem save(ShippingLineItem shippingLineItem) {
      return shippingLineItemDao.save(shippingLineItem);
   }

   @Override
   public Optional<ShippingLineItem> get(long id) {
      return shippingLineItemDao.findById(id);
   }
   
   @Override
   public Page<ShippingLineItem> getShippingLineItemsByPage(Integer pageNumber, Integer pageSize) {
	   logger.info("inside getShippingLineItemsByPage service");
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
	   return shippingLineItemDao.findAll(pageable);
   }

    @Override
   public void update(long id, ShippingLineItem shippingLineItem) {
      shippingLineItemDao.save(shippingLineItem);
   }

   
   @Override
   public void delete(long id) {
      shippingLineItemDao.deleteById(id);
   }

	@Override
	public List<ROShippingLineItem> getShippingLineItemsByShippingIdID(Long id) {
		return shippingLineItemDao.getShippingLineItemsByShippingID(id);
	}


}
