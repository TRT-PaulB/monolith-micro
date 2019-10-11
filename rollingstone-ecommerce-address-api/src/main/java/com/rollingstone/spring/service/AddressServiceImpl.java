package com.rollingstone.spring.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.AddressDaoRepository;
import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.AddressDTO;

@Service
public class AddressServiceImpl implements AddressService {

	  final static Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

   @Autowired
   private AddressDaoRepository addressDao;  
  
   @Override
   public Address save(Address address) {
      return addressDao.save(address);
   }
   
   @Override
   public    AddressDTO getAddressPartial(long id) {
	   return addressDao.getAddressByID(id);
   }

 

   @Override
   public Page<Address> getAddresssByPage(Integer pageNumber, Integer pageSize) {
	   Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
	   return addressDao.findAll(pageable);
   }

   @Override
   public void update(long id, Address address) {
      addressDao.save(address);
   }

   
   @Override
   public void delete(long id) {
      addressDao.deleteById(id);
   }

}
