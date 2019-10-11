package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.AddressDTO;

public interface AddressService {

   Address save(Address address);
   AddressDTO getAddressPartial(long id);
   Page<Address> getAddresssByPage(Integer pageNumber, Integer pageSize);
   void update(long id, Address address);
   void delete(long id);
}
