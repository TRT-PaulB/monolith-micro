package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.Cart;

public interface CartDaoRepository extends PagingAndSortingRepository<Cart, Long> {

	Page<Cart> findAll(Pageable pageable);
}
