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

import com.rollingstone.spring.dao.SPUDaoRepository;
import com.rollingstone.spring.model.StorePickUp;

@Service
public class SPUServiceImpl implements SPUService {

	  final static Logger logger = LoggerFactory.getLogger(SPUServiceImpl.class);

   @Autowired
   private SPUDaoRepository spuDao;  
  
   @Override
   public StorePickUp save(StorePickUp spu) {
      return spuDao.save(spu);
   }

   @Override
   public Optional<StorePickUp> get(long id) {
      return spuDao.findById(id);
   }

   @Override
   public Page<StorePickUp> getStorePickUpsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("storeName").descending());
	   return spuDao.findAll(pageable);
   }

   @Override
   public void update(long id, StorePickUp spu) {
      spuDao.save(spu);
   }

   
   @Override
   public void delete(long id) {
      spuDao.deleteById(id);
   }

}
