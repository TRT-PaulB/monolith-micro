package com.rollingstone.spring.service;

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

import com.rollingstone.spring.dao.CartDaoRepository;
import com.rollingstone.spring.model.Cart;

@Service
public class CartServiceImpl implements CartService {

	  final static Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

   @Autowired
   private CartDaoRepository cartDao;  
  
   @Override
   public Cart save(Cart cart) {
      return cartDao.save(cart);
   }

   @Override
   public Optional<Cart> get(long id) {
      return cartDao.findById(id);
   }

   @Override
   public Page<Cart> getCartsByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("cartTotal").descending());
	   return cartDao.findAll(pageable);
   }
   
   @Override
   public Iterable<Cart> getCarts() {
	   return cartDao.findAll();
   }

   @Override
   public void update(long id, Cart cart) {
      cartDao.save(cart);
   }

   
   @Override
   public void delete(long id) {
      cartDao.deleteById(id);
   }

}
