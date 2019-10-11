package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.Promo;

public interface PromoDaoRepository extends PagingAndSortingRepository<Promo, Long> {

	Page<Promo> findAll(Pageable pageable);
}
