package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.OrderLineItem;

public interface OrderLineItemDaoRepository extends PagingAndSortingRepository<OrderLineItem, Long> {

	Page<OrderLineItem> findAll(Pageable pageable);
}
