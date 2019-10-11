package com.rollingstone.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.spring.model.ROShipping;
import com.rollingstone.spring.model.Shipping;

public interface ShippingDaoRepository extends PagingAndSortingRepository<Shipping, Long> {

	Page<Shipping> findAll(Pageable pageable);
	
	@Query(name="ShippingDaoRepository.getShippingByOrderID", nativeQuery = true)
	List<ROShipping> getShippingByOrderID(@Param("id") long id);
}
