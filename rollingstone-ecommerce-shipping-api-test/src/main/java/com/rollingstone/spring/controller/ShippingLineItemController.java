package com.rollingstone.spring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.ShippingLineItemEvent;
import com.rollingstone.spring.model.ROShippingLineItem;
import com.rollingstone.spring.model.ShippingLineItem;
import com.rollingstone.spring.service.ShippingLineItemService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account/{id}/order/{orderId}/shipping/{shippingId}")
public class ShippingLineItemController extends AbstractController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
   private ShippingLineItemService  shippingLineItemService;
   
   public ShippingLineItemController(ShippingLineItemService shippingLineItemService) {
	   this.shippingLineItemService = shippingLineItemService;
   }

   /*---Add new ShippingLineItem---*/
   @PostMapping("/shipping-item")
   public ResponseEntity<?> createShippingLineItem(@RequestBody ShippingLineItem shippingLineItem) {
      ShippingLineItem savedShippingLineItem = shippingLineItemService.save(shippingLineItem);
      ShippingLineItemEvent ShippingLineItemCreatedEvent = new ShippingLineItemEvent(this, "ShippingLineItemCreatedEvent", savedShippingLineItem);
      eventPublisher.publishEvent(ShippingLineItemCreatedEvent);
      return ResponseEntity.ok().body("New ShippingLineItem has been saved with ID:" + savedShippingLineItem.getId());
   }

   /*---Get a ShippingLineItem by Shipping id---*/
   @GetMapping("/shipping-item")
   @ResponseBody
   public List<ROShippingLineItem> getShippijgLineItemsByOrderId(@PathVariable("shippingId") long shippingId) {
	   List<ROShippingLineItem> shipmentLineItems = shippingLineItemService.getShippingLineItemsByShippingIdID(shippingId);
	  return shipmentLineItems;
   }
   
   /*---Get a ShippingLineItem by id---*/
   @GetMapping("/shipping-item/{id}")
   @ResponseBody
   public ShippingLineItem get(@PathVariable("id") Long id) {
	   logger.info("inside get ROShippingLineItem");
	   	Optional<ShippingLineItem> optionalLineItem = shippingLineItemService.get(id);
	   	ShippingLineItem lineItem = optionalLineItem.get();
		return lineItem;
	}
 
   /*---Update a ShippingLineItem by id---*/
   @PutMapping("/shipping-item/{id}")
   public ResponseEntity<?> updateShippingLineItem(@PathVariable("id") long id, @RequestBody ShippingLineItem shippingLineItemLineItem) {
	  checkResourceFound(this.shippingLineItemService.get(id));
	  shippingLineItemService.update(id, shippingLineItemLineItem);
      return ResponseEntity.ok().body("ShippingLineItem has been updated successfully.");
   }

   /*---Delete a ShippingLineItem by id---*/
   @DeleteMapping("/shipping-item/{id}")
   public ResponseEntity<?> deleteShippingLineItem(@PathVariable("id") long id) {
	  checkResourceFound(this.shippingLineItemService.get(id));
	  shippingLineItemService.delete(id);
      return ResponseEntity.ok().body("ShippingLineItem has been deleted successfully.");
   }
}