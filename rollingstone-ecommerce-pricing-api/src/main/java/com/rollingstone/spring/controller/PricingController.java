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

import com.rollingstone.events.PricingEvent;
import com.rollingstone.spring.model.Pricing;
import com.rollingstone.spring.service.PricingService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class PricingController extends AbstractController {

  
   private PricingService  pricingService;
   
   public PricingController(PricingService pricingService) {
	   this.pricingService = pricingService;
   }

   /*---Add new Pricing---*/
   @PostMapping("/pricing")
   public ResponseEntity<?> createPricing(@RequestBody Pricing Pricing) {
      Pricing savedPricing = pricingService.save(Pricing);
      PricingEvent PricingCreatedEvent = new PricingEvent(this, "PricingCreatedEvent", savedPricing);
      eventPublisher.publishEvent(PricingCreatedEvent);
      return ResponseEntity.ok().body("New Pricing has been saved with ID:" + savedPricing.getId());
   }

   /*---Get a Pricing by id---*/
   @GetMapping("/pricing/{id}")
   @ResponseBody
   public Pricing getPricing(@PathVariable("id") long id) {
	  Optional<Pricing> returnedPricing = pricingService.get(id);
	  Pricing Pricing  = returnedPricing.get(); 
	  
	  PricingEvent PricingCreatedEvent = new PricingEvent(this, "PricingRetrievedEvent", Pricing);
      eventPublisher.publishEvent(PricingCreatedEvent);
      return Pricing;
   }
   
 

   /*---get all Pricing---*/
   @GetMapping("/pricing")
   public @ResponseBody Page<Pricing> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Pricing> pagedPricings = pricingService.getPricingsByPage(pageNumber, pageSize);
      return pagedPricings;
   }

   /*---Update a Pricing by id---*/
   @PutMapping("/pricing/{id}")
   public ResponseEntity<?> updatePricing(@PathVariable("id") long id, @RequestBody Pricing pricing) {
	  checkResourceFound(this.pricingService.get(id));
	  pricingService.update(id, pricing);
      return ResponseEntity.ok().body("Pricing has been updated successfully.");
   }

   /*---Delete a Pricing by id---*/
   @DeleteMapping("/pricing/{id}")
   public ResponseEntity<?> deletePricing(@PathVariable("id") long id) {
	  checkResourceFound(this.pricingService.get(id));
	  pricingService.delete(id);
      return ResponseEntity.ok().body("Pricing has been deleted successfully.");
   }
}