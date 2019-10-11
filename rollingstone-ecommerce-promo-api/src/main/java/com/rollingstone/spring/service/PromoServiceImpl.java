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

import com.rollingstone.spring.dao.PromoDaoRepository;
import com.rollingstone.spring.model.Promo;

@Service
public class PromoServiceImpl implements PromoService {

	  final static Logger logger = LoggerFactory.getLogger(PromoServiceImpl.class);

   @Autowired
   private PromoDaoRepository promoDao;  
  
   @Override
   public Promo save(Promo promo) {
      return promoDao.save(promo);
   }

   @Override
   public Optional<Promo> get(long id) {
      return promoDao.findById(id);
   }

   @Override
   public Page<Promo> getPromosByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("promoName").descending());
	   return promoDao.findAll(pageable);
   }

   @Override
   public void update(long id, Promo promo) {
      promoDao.save(promo);
   }

   
   @Override
   public void delete(long id) {
      promoDao.deleteById(id);
   }

}
