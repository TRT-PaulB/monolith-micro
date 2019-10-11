package com.micro.pbecommerceproductapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.micro.pbecommerceproductapi.dm.Product;

public interface ProductService {

   Product save(Product product);
   Optional<Product> get(long id);
   
   //List<Product> list();
   Page<Product> getProductsByPage(Integer pageNum, Integer pageSize);
   
   void update(Product product);
   void delete(long id);
}
