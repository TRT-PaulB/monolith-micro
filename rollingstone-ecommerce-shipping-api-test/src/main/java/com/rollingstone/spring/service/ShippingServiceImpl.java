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
import com.rollingstone.spring.dao.ShippingDaoRepository;
import com.rollingstone.spring.model.Product;
import com.rollingstone.spring.model.ROShipping;
import com.rollingstone.spring.model.ROShippingLineItem;
import com.rollingstone.spring.model.Shipping;
import com.rollingstone.spring.model.ShippingLineItem;

@Service
public class ShippingServiceImpl implements ShippingService {

	  final static Logger logger = LoggerFactory.getLogger(ShippingServiceImpl.class);

   @Autowired
   private ShippingDaoRepository shippingDao;  
   
   @Autowired
   private ProductDaoRepository productDao;  
  
   @Override
   public Shipping save(Shipping shipping) {
      return shippingDao.save(shipping);
   }

   @Override
   public Optional<Shipping> get(long id) {
      return shippingDao.findById(id);
   }

   @Override
   public    List<ROShipping> getShipmentsByOrderID(Long id)
   {
	   return shippingDao.getShippingByOrderID(id);
   }
   
   @Override
   public Page<Shipping> getShippingsByPage(Integer pageNumber, Integer pageSize) {
	   logger.info("inside getShippingsByPage service");
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("shippingCharge").descending());
	   return shippingDao.findAll(pageable);
   }

   @Override
   public ROShipping getShipping(Long shippingId) {
		
		Optional<Shipping> shippingOptional =  shippingDao.findById(shippingId);
		
		Shipping shipping = shippingOptional.get();
		
		Set<ShippingLineItem> shippingItems = shipping.getShippingItems();
		
		/*Set<ROShippingLineItem> roShippingItems = new HashSet<ROShippingLineItem>();
		
		for (ShippingLineItem lineItem : shippingItems) {
			Optional<Product> optionalProduct = productDao.findById(lineItem.getProductId());
			
			Product product = optionalProduct.get();
			
			ROShippingLineItem roShippingItem = new ROShippingLineItem();
			
			roShippingItem.setId(lineItem.getId());
			roShippingItem.setProductCode(product.getProductCode());
			roShippingItem.setProductName(product.getProductName());
			roShippingItem.setQuantity(lineItem.getQuantityShipped());
			roShippingItem.setUnitOfMeasurement(lineItem.getUom());
			roShippingItem.setUnitPrice(lineItem.getUnitPrice());
			
			roShippingItems.add(roShippingItem);
			
		}*/
		
		ROShipping roShipping = new ROShipping();
		
		roShipping.setAvailable(shipping.isAvailable());
		roShipping.setAvailableDate(shipping.getArrivalDate());
		roShipping.setDaysInTransit(shipping.getDaysInTransit());
		roShipping.setFree(shipping.isFree());
		roShipping.setFreeShippingForMembers(shipping.isFreeForMembers());
		roShipping.setId(shipping.getId());
		roShipping.setOfferId(shipping.getOfferId());
		
		roShipping.setOrderDate(shipping.getOrder().getOrderDate());
		roShipping.setOrderNumber(shipping.getOrder().getOrderNumber());
		roShipping.setShipCarrier(shipping.getShipCarrier());
		roShipping.setShippingCharge(shipping.getShippingCharge());
		roShipping.setShippingMode(shipping.getShippingMode());
		
		//roShipping.setShippingItems(roShippingItems);
		
		
		return roShipping;
	}
   @Override
   public void update(long id, Shipping shipping) {
      shippingDao.save(shipping);
   }

   
   @Override
   public void delete(long id) {
      shippingDao.deleteById(id);
   }

}
