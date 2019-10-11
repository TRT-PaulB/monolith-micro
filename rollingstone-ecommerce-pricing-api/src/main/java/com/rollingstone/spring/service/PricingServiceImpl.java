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

import com.rollingstone.spring.dao.PricingDaoRepository;
import com.rollingstone.spring.model.Pricing;

@Service
public class PricingServiceImpl implements PricingService {

	  final static Logger logger = LoggerFactory.getLogger(PricingServiceImpl.class);

   @Autowired
   private PricingDaoRepository pricingDao;  
  
   @Override
   public Pricing save(Pricing pricing) {
      return pricingDao.save(pricing);
   }

   @Override
   public Optional<Pricing> get(long id) {
      return pricingDao.findById(id);
   }

   @Override
   public Page<Pricing> getPricingsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productCode").descending());
	   return pricingDao.findAll(pageable);
   }

   @Override
   public void update(long id, Pricing pricing) {
      pricingDao.save(pricing);
   }

   
   @Override
   public void delete(long id) {
      pricingDao.deleteById(id);
   }

}
