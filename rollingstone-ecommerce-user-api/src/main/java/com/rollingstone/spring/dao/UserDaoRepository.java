package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rollingstone.spring.model.User;

public interface UserDaoRepository extends PagingAndSortingRepository<User, Long> {

	Page<User> findAll(Pageable pageable);
}
