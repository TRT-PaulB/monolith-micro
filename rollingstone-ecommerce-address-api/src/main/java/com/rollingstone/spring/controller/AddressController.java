package com.rollingstone.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.AddressEvent;
import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.AddressDTO;
import com.rollingstone.spring.service.AddressService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class AddressController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
  
   private AddressService  addressService;
   
   public AddressController(AddressService addressService) {
	   this.addressService = addressService;
   }

   /*---Add new Address---*/
   @PostMapping("/address")
   public ResponseEntity<?> createAddress(@RequestBody Address address) {
      Address savedAddress = addressService.save(address);
      AddressDTO addressDTO = addressService.getAddressPartial(savedAddress.getId());
      AddressEvent addressCreatedEvent = new AddressEvent(this, "AddressCreatedEvent", addressDTO);
      eventPublisher.publishEvent(addressCreatedEvent);
      return ResponseEntity.ok().body("New Address has been saved with ID:" + savedAddress.getId());
   }

   /*---Get a Address by id---*/
   @GetMapping("/address/{id}")
   @ResponseBody
   public AddressDTO getAddress(@PathVariable("id") long id) {
	  AddressDTO address = addressService.getAddressPartial(id);
	  logger.info("Address is :"+address.toString());
	  AddressEvent addressCreatedEvent = new AddressEvent(this, "AddressRetrievedEvent", address);
      eventPublisher.publishEvent(addressCreatedEvent);
      return address;
   }
   
 

   /*---get all Address---*/
   @GetMapping("/address")
   public @ResponseBody Page<Address> getAddressByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Address> pagedAddresses = addressService.getAddresssByPage(pageNumber, pageSize);
      return pagedAddresses;
   }

   /*---Update a Address by id---*/
   @PutMapping("/address/{id}")
   public ResponseEntity<?> updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
	  checkResourceFound(this.addressService.getAddressPartial(id));
	  addressService.update(id, address);
      return ResponseEntity.ok().body("Address has been updated successfully.");
   }

   /*---Delete a Address by id---*/
   @DeleteMapping("/address/{id}")
   public ResponseEntity<?> deleteAddress(@PathVariable("id") long id) {
		  checkResourceFound(this.addressService.getAddressPartial(id));
	  addressService.delete(id);
      return ResponseEntity.ok().body("Address has been deleted successfully.");
   }
}