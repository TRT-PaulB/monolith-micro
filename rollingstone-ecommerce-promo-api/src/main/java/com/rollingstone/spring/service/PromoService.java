package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Promo;

public interface PromoService {

   Promo save(Promo promo);
   Optional<Promo> get(long id);
   Page<Promo> getPromosByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Promo promo);
   void delete(long id);
}
