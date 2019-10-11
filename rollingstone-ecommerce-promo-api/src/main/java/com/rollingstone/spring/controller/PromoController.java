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

import com.rollingstone.events.PromoEvent;
import com.rollingstone.spring.model.Promo;
import com.rollingstone.spring.service.PromoService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class PromoController extends AbstractController {

  
   private PromoService  promoService;
   
   public PromoController(PromoService promoService) {
	   this.promoService = promoService;
   }

   /*---Add new Promo---*/
   @PostMapping("/promo")
   public ResponseEntity<?> createPromo(@RequestBody Promo Promo) {
      Promo savedPromo = promoService.save(Promo);
      PromoEvent PromoCreatedEvent = new PromoEvent(this, "PromoCreatedEvent", savedPromo);
      eventPublisher.publishEvent(PromoCreatedEvent);
      return ResponseEntity.ok().body("New Promo has been saved with ID:" + savedPromo.getId());
   }

   /*---Get a Promo by id---*/
   @GetMapping("/promo/{id}")
   @ResponseBody
   public Promo getPromo(@PathVariable("id") long id) {
	  Optional<Promo> returnedPromo = promoService.get(id);
	  Promo Promo  = returnedPromo.get(); 
	  
	  PromoEvent PromoCreatedEvent = new PromoEvent(this, "PromoRetrievedEvent", Promo);
      eventPublisher.publishEvent(PromoCreatedEvent);
      return Promo;
   }
   
 

   /*---get all Promo---*/
   @GetMapping("/promo")
   public @ResponseBody Page<Promo> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Promo> pagedPromos = promoService.getPromosByPage(pageNumber, pageSize);
      return pagedPromos;
   }

   /*---Update a Promo by id---*/
   @PutMapping("/promo/{id}")
   public ResponseEntity<?> updatePromo(@PathVariable("id") long id, @RequestBody Promo promo) {
	  checkResourceFound(this.promoService.get(id));
	  promoService.update(id, promo);
      return ResponseEntity.ok().body("Promo has been updated successfully.");
   }

   /*---Delete a Promo by id---*/
   @DeleteMapping("/promo/{id}")
   public ResponseEntity<?> deletePromo(@PathVariable("id") long id) {
	  checkResourceFound(this.promoService.get(id));
	  promoService.delete(id);
      return ResponseEntity.ok().body("Promo has been deleted successfully.");
   }
}