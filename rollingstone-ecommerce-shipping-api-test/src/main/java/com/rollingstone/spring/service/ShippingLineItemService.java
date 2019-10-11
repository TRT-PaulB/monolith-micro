package com.rollingstone.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.ROShipping;
import com.rollingstone.spring.model.ROShippingLineItem;
import com.rollingstone.spring.model.ShippingLineItem;

public interface ShippingLineItemService {

   ShippingLineItem save(ShippingLineItem shipping);
   Optional<ShippingLineItem> get(long id);
   List<ROShippingLineItem> getShippingLineItemsByShippingIdID(Long id);
   Page<ShippingLineItem> getShippingLineItemsByPage(Integer pageNumber, Integer pageSize);
   void update(long id, ShippingLineItem shipping);
   void delete(long id);
}
