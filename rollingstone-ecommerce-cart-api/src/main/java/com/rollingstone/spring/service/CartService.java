package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Cart;

public interface CartService {

   Cart save(Cart cart);
   Optional<Cart> get(long id);
   Page<Cart> getCartsByPage(Integer pageNumber, Integer pageSize);
   Iterable<Cart> getCarts();
   void update(long id, Cart cart);
   void delete(long id);
}
