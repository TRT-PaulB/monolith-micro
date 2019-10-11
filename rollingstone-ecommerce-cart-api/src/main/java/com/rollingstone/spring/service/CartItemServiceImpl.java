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

import com.rollingstone.spring.dao.CartItemDaoRepository;
import com.rollingstone.spring.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	  final static Logger logger = LoggerFactory.getLogger(CartItemServiceImpl.class);

   @Autowired
   private CartItemDaoRepository cartItemDao;  
  
   @Override
   public CartItem save(CartItem cartItem) {
      return cartItemDao.save(cartItem);
   }

   @Override
   public Optional<CartItem> get(long id) {
      return cartItemDao.findById(id);
   }

   @Override
   public Page<CartItem> getCartItemsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
	   return cartItemDao.findAll(pageable);
   }
   
   @Override
   public Iterable<CartItem> getCartItems() {
	   return cartItemDao.findAll();
   }

   @Override
   public void update(long id, CartItem cartItem) {
      cartItemDao.save(cartItem);
   }

   
   @Override
   public void delete(long id) {
      cartItemDao.deleteById(id);
   }

}
