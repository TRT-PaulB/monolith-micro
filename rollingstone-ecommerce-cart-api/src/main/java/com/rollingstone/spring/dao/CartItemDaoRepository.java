package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.CartItem;

public interface CartItemDaoRepository extends PagingAndSortingRepository<CartItem, Long> {

	Page<CartItem> findAll(Pageable pageable);
}
