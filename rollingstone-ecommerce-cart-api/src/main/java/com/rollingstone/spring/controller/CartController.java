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

import com.rollingstone.events.CartEvent;
import com.rollingstone.spring.model.Cart;
import com.rollingstone.spring.service.CartService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class CartController extends AbstractController {

  
   private CartService  cartService;
   
   public CartController(CartService cartService) {
	   this.cartService = cartService;
   }

   /*---Add new Cart---*/
   @PostMapping("/cart")
   public ResponseEntity<?> createCart(@RequestBody Cart Cart) {
      Cart savedCart = cartService.save(Cart);
      CartEvent CartCreatedEvent = new CartEvent(this, "CartCreatedEvent", savedCart);
      eventPublisher.publishEvent(CartCreatedEvent);
      return ResponseEntity.ok().body("New Cart has been saved with ID:" + savedCart.getId());
   }

   /*---Get a Cart by id---*/
   @GetMapping("/cart/{id}")
   @ResponseBody
   public Cart getCart(@PathVariable("id") long id) {
	  Optional<Cart> returnedCart = cartService.get(id);
	  Cart Cart  = returnedCart.get(); 
	  
	  CartEvent CartCreatedEvent = new CartEvent(this, "CartRetrievedEvent", Cart);
      eventPublisher.publishEvent(CartCreatedEvent);
      return Cart;
   }
   
 

   /*---get all Cart---*/
   @GetMapping("/cart")
   public @ResponseBody Page<Cart> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Cart> pagedCarts = cartService.getCartsByPage(pageNumber, pageSize);
      return pagedCarts;
   }
   
   /*---get all Cart---*/
   @GetMapping("/carts")
   public @ResponseBody Iterable<Cart> getCarts() {
      Iterable<Cart> carts = cartService.getCarts();
      return carts;
   }

   /*---Update a Cart by id---*/
   @PutMapping("/cart/{id}")
   public ResponseEntity<?> updateCart(@PathVariable("id") long id, @RequestBody Cart cart) {
	  checkResourceFound(this.cartService.get(id));
	  cartService.update(id, cart);
      return ResponseEntity.ok().body("Cart has been updated successfully.");
   }

   /*---Delete a Cart by id---*/
   @DeleteMapping("/cart/{id}")
   public ResponseEntity<?> deleteCart(@PathVariable("id") long id) {
	  checkResourceFound(this.cartService.get(id));
	  cartService.delete(id);
      return ResponseEntity.ok().body("Cart has been deleted successfully.");
   }
}