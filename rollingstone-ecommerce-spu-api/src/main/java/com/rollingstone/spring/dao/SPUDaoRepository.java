package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.StorePickUp;

public interface SPUDaoRepository extends PagingAndSortingRepository<StorePickUp, Long> {

	Page<StorePickUp> findAll(Pageable pageable);
}
