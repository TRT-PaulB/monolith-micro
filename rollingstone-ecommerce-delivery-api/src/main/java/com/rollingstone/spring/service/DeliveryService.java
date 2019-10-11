package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Delivery;

public interface DeliveryService {

   Delivery save(Delivery delivery);
   Optional<Delivery> get(long id);
   Page<Delivery> getDeliverysByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Delivery delivery);
   void delete(long id);
}
