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

import com.rollingstone.events.CartItemEvent;
import com.rollingstone.spring.model.CartItem;
import com.rollingstone.spring.service.CartItemService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account/cart/{cartId}")
public class CartItemController extends AbstractController {

  
   private CartItemService  cartService;
   
   public CartItemController(CartItemService cartService) {
	   this.cartService = cartService;
   }

   /*---Add new CartItem---*/
   @PostMapping("/cart-item")
   public ResponseEntity<?> createCartItem(@RequestBody CartItem cartItem) {
      CartItem savedCartItem = cartService.save(cartItem);
      CartItemEvent CartItemCreatedEvent = new CartItemEvent(this, "CartItemCreatedEvent", savedCartItem);
      eventPublisher.publishEvent(CartItemCreatedEvent);
      return ResponseEntity.ok().body("New CartItem has been saved with ID:" + savedCartItem.getId());
   }

   /*---Get a CartItem by id---*/
   @GetMapping("/cart-item/{id}")
   @ResponseBody
   public CartItem getCartItem(@PathVariable("id") long id) {
	  Optional<CartItem> returnedCartItem = cartService.get(id);
	  CartItem CartItem  = returnedCartItem.get(); 
	  
	  CartItemEvent CartItemCreatedEvent = new CartItemEvent(this, "CartItemRetrievedEvent", CartItem);
      eventPublisher.publishEvent(CartItemCreatedEvent);
      return CartItem;
   }
   
 

   /*---get all CartItem---*/
   @GetMapping("/cart-item")
   public @ResponseBody Page<CartItem> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<CartItem> pagedCartItems = cartService.getCartItemsByPage(pageNumber, pageSize);
      return pagedCartItems;
   }
   


   /*---Update a CartItem by id---*/
   @PutMapping("/cart-item/{id}")
   public ResponseEntity<?> updateCartItem(@PathVariable("id") long id, @RequestBody CartItem cart) {
	  checkResourceFound(this.cartService.get(id));
	  cartService.update(id, cart);
      return ResponseEntity.ok().body("CartItem has been updated successfully.");
   }

   /*---Delete a CartItem by id---*/
   @DeleteMapping("/cart-item/{id}")
   public ResponseEntity<?> deleteCartItem(@PathVariable("id") long id) {
	  checkResourceFound(this.cartService.get(id));
	  cartService.delete(id);
      return ResponseEntity.ok().body("CartItem has been deleted successfully.");
   }
}