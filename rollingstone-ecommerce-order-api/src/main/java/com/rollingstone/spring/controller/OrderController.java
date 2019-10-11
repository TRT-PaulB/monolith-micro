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

import com.rollingstone.events.OrderEvent;
import com.rollingstone.spring.model.Order;
import com.rollingstone.spring.service.OrderService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account/{id}")
public class OrderController extends AbstractController {

  
   private OrderService  orderService;
   
   public OrderController(OrderService orderService) {
	   this.orderService = orderService;
   }

   /*---Add new Order---*/
   @PostMapping("/order")
   public ResponseEntity<?> createOrder(@RequestBody Order order) {
      Order savedOrder = orderService.save(order);
      OrderEvent OrderCreatedEvent = new OrderEvent(this, "OrderCreatedEvent", savedOrder);
      eventPublisher.publishEvent(OrderCreatedEvent);
      return ResponseEntity.ok().body("New Order has been saved with ID:" + savedOrder.getId());
   }

   /*---Get a Order by id---*/
   @GetMapping("/order/{id}")
   @ResponseBody
   public Order getOrder(@PathVariable("id") long id) {
	  Optional<Order> returnedOrder = orderService.get(id);
	  Order Order  = returnedOrder.get(); 
	  
	  OrderEvent OrderCreatedEvent = new OrderEvent(this, "OrderRetrievedEvent", Order);
      eventPublisher.publishEvent(OrderCreatedEvent);
      return Order;
   }
   
 

   /*---get all Order---*/
   @GetMapping("/order")
   public @ResponseBody Page<Order> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Order> pagedOrders = orderService.getOrdersByPage(pageNumber, pageSize);
      return pagedOrders;
   }

   /*---Update a Order by id---*/
   @PutMapping("/order/{id}")
   public ResponseEntity<?> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
	  checkResourceFound(this.orderService.get(id));
	  orderService.update(id, order);
      return ResponseEntity.ok().body("Order has been updated successfully.");
   }

   /*---Delete a Order by id---*/
   @DeleteMapping("/order/{id}")
   public ResponseEntity<?> deleteOrder(@PathVariable("id") long id) {
	  checkResourceFound(this.orderService.get(id));
	  orderService.delete(id);
      return ResponseEntity.ok().body("Order has been deleted successfully.");
   }
}