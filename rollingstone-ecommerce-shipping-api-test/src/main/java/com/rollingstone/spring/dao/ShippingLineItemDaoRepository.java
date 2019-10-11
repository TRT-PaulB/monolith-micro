package com.rollingstone.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.spring.model.ROShippingLineItem;
import com.rollingstone.spring.model.ShippingLineItem;

public interface ShippingLineItemDaoRepository extends PagingAndSortingRepository<ShippingLineItem, Long> {

	Page<ShippingLineItem> findAll(Pageable pageable);
	
	@Query(name="ShippingLineItemDaoRepository.getShippingLineItemsByShippingID", nativeQuery = true)
	List<ROShippingLineItem> getShippingLineItemsByShippingID(@Param("id") long id);
}
