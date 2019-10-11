package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.StorePickUp;

public interface SPUService {

   StorePickUp save(StorePickUp spu);
   Optional<StorePickUp> get(long id);
   Page<StorePickUp> getStorePickUpsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, StorePickUp spu);
   void delete(long id);
}
