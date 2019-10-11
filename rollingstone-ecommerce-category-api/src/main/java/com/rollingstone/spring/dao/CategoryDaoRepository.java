package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.Category;

public interface CategoryDaoRepository extends PagingAndSortingRepository<Category, Long> {

	Page<Category> findAll(Pageable pageable);
}
