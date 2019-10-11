package com.rollingstone.spring.controller;

import java.util.List;

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

import com.rollingstone.events.ShippingEvent;
import com.rollingstone.spring.model.AddressDTO;
import com.rollingstone.spring.model.ROShipping;
import com.rollingstone.spring.model.Shipping;
import com.rollingstone.spring.service.ShippingService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account/{id}/order/{orderId}")
public class ShippingController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
   private ShippingService  shippingService;
   
   public ShippingController(ShippingService shippingService) {
	   this.shippingService = shippingService;
   }

   /*---Add new Shipping---*/
   @PostMapping("/shipping")
   public ResponseEntity<?> createShipping(@RequestBody Shipping shipping) {
      Shipping savedShipping = shippingService.save(shipping);
      ShippingEvent ShippingCreatedEvent = new ShippingEvent(this, "ShippingCreatedEvent", savedShipping);
      eventPublisher.publishEvent(ShippingCreatedEvent);
      return ResponseEntity.ok().body("New Shipping has been saved with ID:" + savedShipping.getId());
   }

   /*---Get a Shipping by id---*/
   @GetMapping("/shipping")
   @ResponseBody
   public List<ROShipping> getShippijgByOrderId(@PathVariable("orderId") long orderId) {
	   List<ROShipping> shipments = shippingService.getShipmentsByOrderID(orderId);
	  
	
      return shipments;
   }
   
   /*---Get a Shipping by id---*/
   @GetMapping("/shipping/{id}")
   @ResponseBody
   public ROShipping get(@PathVariable("id") Long id) {
	   logger.info("inside get ROShipping");

		ROShipping shipping  = shippingService.getShipping(id);
		return shipping;
	}
 

 /*  ---get all Shipping---
   @GetMapping("/shipping")
   public @ResponseBody Page<Shipping> getShippingByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
	   logger.info("inside getShippingByPage");
      Page<Shipping> pagedShippings = shippingService.getShippingsByPage(pageNumber, pageSize);
      return pagedShippings;
   }*/

   /*---Update a Shipping by id---*/
   @PutMapping("/shipping/{id}")
   public ResponseEntity<?> updateShipping(@PathVariable("id") long id, @RequestBody Shipping shipping) {
	  checkResourceFound(this.shippingService.get(id));
	  shippingService.update(id, shipping);
      return ResponseEntity.ok().body("Shipping has been updated successfully.");
   }

   /*---Delete a Shipping by id---*/
   @DeleteMapping("/shipping/{id}")
   public ResponseEntity<?> deleteShipping(@PathVariable("id") long id) {
	  checkResourceFound(this.shippingService.get(id));
	  shippingService.delete(id);
      return ResponseEntity.ok().body("Shipping has been deleted successfully.");
   }
}