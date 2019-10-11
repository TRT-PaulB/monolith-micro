package com.rollingstone.spring.controller;

import java.util.Optional;

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

import com.rollingstone.events.OrderLineItemEvent;
import com.rollingstone.spring.model.OrderLineItem;
import com.rollingstone.spring.service.OrderLineItemService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account/{accunt-id}/order/{order-id}")
public class OrderLineItemController extends AbstractController {

	Logger logger = LoggerFactory.getLogger("OrderLineItemController");

   private OrderLineItemService  orderLineItemService;
   
   public OrderLineItemController(OrderLineItemService orderLineItemService) {
	   this.orderLineItemService = orderLineItemService;
   }

   /*---Add new OrderLineItem---*/
   @PostMapping("/order-item")
   public ResponseEntity<?> createOrderLineItemLineItem(@RequestBody OrderLineItem order) {
      OrderLineItem savedOrderLineItem = orderLineItemService.save(order);
      OrderLineItemEvent OrderLineItemCreatedEvent = new OrderLineItemEvent(this, "OrderLineItemCreatedEvent", savedOrderLineItem);
      eventPublisher.publishEvent(OrderLineItemCreatedEvent);
      return ResponseEntity.ok().body("New OrderLineItem has been saved with ID:" + savedOrderLineItem.getId());
   }

   /*---Get a OrderLineItem by id---*/
   @GetMapping("/order-item/{id}")
   @ResponseBody
   public OrderLineItem getOrderLineItem(@PathVariable("id") long id) {
		logger.info("getOrderLineItem 1 :" );
	  Optional<OrderLineItem> returnedOrderLineItem = orderLineItemService.get(id);
	  
		logger.info("getOrderLineItem 2 :" );

	  OrderLineItem OrderLineItem  = returnedOrderLineItem.get(); 
	  
	  OrderLineItemEvent OrderLineItemCreatedEvent = new OrderLineItemEvent(this, "OrderLineItemRetrievedEvent", OrderLineItem);
      eventPublisher.publishEvent(OrderLineItemCreatedEvent);
      
		logger.info("getOrderLineItem 3 :" );

      return OrderLineItem;
   }
   
 

   /*---get all OrderLineItem---*/
   @GetMapping("/order-item")
   public @ResponseBody Page<OrderLineItem> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<OrderLineItem> pagedOrderLineItems = orderLineItemService.getOrderLineItemsByPage(pageNumber, pageSize);
      return pagedOrderLineItems;
   }

   /*---Update a OrderLineItem by id---*/
   @PutMapping("/order-item/{id}")
   public ResponseEntity<?> updateOrderLineItem(@PathVariable("id") long id, @RequestBody OrderLineItem order) {
	  checkResourceFound(this.orderLineItemService.get(id));
	  orderLineItemService.update(id, order);
      return ResponseEntity.ok().body("OrderLineItem has been updated successfully.");
   }

   /*---Delete a OrderLineItem by id---*/
   @DeleteMapping("/order-item/{id}")
   public ResponseEntity<?> deleteOrderLineItem(@PathVariable("id") long id) {
	  checkResourceFound(this.orderLineItemService.get(id));
	  orderLineItemService.delete(id);
      return ResponseEntity.ok().body("OrderLineItem has been deleted successfully.");
   }
}