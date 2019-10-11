package com.rollingstone.spring.controller;

import java.util.Optional;

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

import com.rollingstone.events.DeliveryEvent;
import com.rollingstone.spring.model.Delivery;
import com.rollingstone.spring.service.DeliveryService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class DeliveryController extends AbstractController {

  
   private DeliveryService  deliveryService;
   
   public DeliveryController(DeliveryService deliveryService) {
	   this.deliveryService = deliveryService;
   }

   /*---Add new Delivery---*/
   @PostMapping("/delivery")
   public ResponseEntity<?> createDelivery(@RequestBody Delivery Delivery) {
      Delivery savedDelivery = deliveryService.save(Delivery);
      DeliveryEvent DeliveryCreatedEvent = new DeliveryEvent(this, "DeliveryCreatedEvent", savedDelivery);
      eventPublisher.publishEvent(DeliveryCreatedEvent);
      return ResponseEntity.ok().body("New Delivery has been saved with ID:" + savedDelivery.getId());
   }

   /*---Get a Delivery by id---*/
   @GetMapping("/delivery/{id}")
   @ResponseBody
   public Delivery getDelivery(@PathVariable("id") long id) {
	  Optional<Delivery> returnedDelivery = deliveryService.get(id);
	  Delivery delivery  = returnedDelivery.get(); 
	  
	  DeliveryEvent DeliveryCreatedEvent = new DeliveryEvent(this, "DeliveryRetrievedEvent", delivery);
      eventPublisher.publishEvent(DeliveryCreatedEvent);
      return delivery;
   }
   
 

   /*---get all Delivery---*/
   @GetMapping("/delivery")
   public @ResponseBody Page<Delivery> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Delivery> pagedDeliverys = deliveryService.getDeliverysByPage(pageNumber, pageSize);
      return pagedDeliverys;
   }

   /*---Update a Delivery by id---*/
   @PutMapping("/delivery/{id}")
   public ResponseEntity<?> updateDelivery(@PathVariable("id") long id, @RequestBody Delivery delivery) {
	  checkResourceFound(this.deliveryService.get(id));
	  deliveryService.update(id, delivery);
      return ResponseEntity.ok().body("Delivery has been updated successfully.");
   }

   /*---Delete a Delivery by id---*/
   @DeleteMapping("/delivery/{id}")
   public ResponseEntity<?> deleteDelivery(@PathVariable("id") long id) {
	  checkResourceFound(this.deliveryService.get(id));
	  deliveryService.delete(id);
      return ResponseEntity.ok().body("Delivery has been deleted successfully.");
   }
}