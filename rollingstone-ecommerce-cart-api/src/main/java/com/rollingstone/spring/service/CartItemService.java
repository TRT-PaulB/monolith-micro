package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.CartItem;

public interface CartItemService {

   CartItem save(CartItem cartItem);
   Optional<CartItem> get(long id);
   Page<CartItem> getCartItemsByPage(Integer pageNumber, Integer pageSize);
   Iterable<CartItem> getCartItems();
   void update(long id, CartItem cartItem);
   void delete(long id);
}
