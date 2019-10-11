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

import com.rollingstone.events.StorePickUpEvent;
import com.rollingstone.spring.model.StorePickUp;
import com.rollingstone.spring.service.SPUService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/")
public class SPUController extends AbstractController {

  
   private SPUService  spuService;
   
   public SPUController(SPUService spuService) {
	   this.spuService = spuService;
   }

   /*---Add new StorePickUp---*/
   @PostMapping("/spu")
   public ResponseEntity<?> createStorePickUp(@RequestBody StorePickUp spu) {
      StorePickUp spuSaved = spuService.save(spu);
      StorePickUpEvent StorePickUpCreatedEvent = new StorePickUpEvent(this, "SPUCreatedEvent", spuSaved);
      eventPublisher.publishEvent(StorePickUpCreatedEvent);
      return ResponseEntity.ok().body("New StorePickUp has been saved with ID:" + spuSaved.getId());
   }

   /*---Get a StorePickUp by id---*/
   @GetMapping("/spu/{id}")
   @ResponseBody
   public StorePickUp getStorePickUp(@PathVariable("id") long id) {
	  Optional<StorePickUp> returnedStorePickUp = spuService.get(id);
	  StorePickUp StorePickUp  = returnedStorePickUp.get(); 
	  
	  StorePickUpEvent StorePickUpCreatedEvent = new StorePickUpEvent(this, "StorePickUpRetrievedEvent", StorePickUp);
      eventPublisher.publishEvent(StorePickUpCreatedEvent);
      return StorePickUp;
   }
   
 

   /*---get all StorePickUp---*/
   @GetMapping("/spu")
   public @ResponseBody Page<StorePickUp> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<StorePickUp> pagedStorePickUps = spuService.getStorePickUpsByPage(pageNumber, pageSize);
      return pagedStorePickUps;
   }

   /*---Update a StorePickUp by id---*/
   @PutMapping("/spu/{id}")
   public ResponseEntity<?> updateStorePickUp(@PathVariable("id") long id, @RequestBody StorePickUp spu) {
	  checkResourceFound(this.spuService.get(id));
	  spuService.update(id, spu);
      return ResponseEntity.ok().body("StorePickUp has been updated successfully.");
   }

   /*---Delete a StorePickUp by id---*/
   @DeleteMapping("/spu/{id}")
   public ResponseEntity<?> deleteStorePickUp(@PathVariable("id") long id) {
	  checkResourceFound(this.spuService.get(id));
	  spuService.delete(id);
      return ResponseEntity.ok().body("StorePickUp has been deleted successfully.");
   }
}