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

import com.rollingstone.events.UserEvent;
import com.rollingstone.spring.model.User;
import com.rollingstone.spring.service.UserService;

@RestController
@RequestMapping(value="/rscommerce/pdp-service/account")
public class UserController extends AbstractController {

  
   private UserService  userService;
   
   public UserController(UserService userService) {
	   this.userService = userService;
   }

   /*---Add new User---*/
   @PostMapping("/user")
   public ResponseEntity<?> createUser(@RequestBody User User) {
      User savedUser = userService.save(User);
      UserEvent UserCreatedEvent = new UserEvent(this, "UserCreatedEvent", savedUser);
      eventPublisher.publishEvent(UserCreatedEvent);
      return ResponseEntity.ok().body("New User has been saved with ID:" + savedUser.getId());
   }

   /*---Get a User by id---*/
   @GetMapping("/user/{id}")
   @ResponseBody
   public User getUser(@PathVariable("id") long id) {
	  Optional<User> returnedUser = userService.get(id);
	  User User  = returnedUser.get(); 
	  
	  UserEvent UserCreatedEvent = new UserEvent(this, "UserRetrievedEvent", User);
      eventPublisher.publishEvent(UserCreatedEvent);
      return User;
   }
   
 

   /*---get all User---*/
   @GetMapping("/user")
   public @ResponseBody Page<User> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<User> pagedUsers = userService.getUsersByPage(pageNumber, pageSize);
      return pagedUsers;
   }

   /*---Update a User by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
	  checkResourceFound(this.userService.get(id));
	  userService.update(id, user);
      return ResponseEntity.ok().body("User has been updated successfully.");
   }

   /*---Delete a User by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
	  checkResourceFound(this.userService.get(id));
	  userService.delete(id);
      return ResponseEntity.ok().body("User has been deleted successfully.");
   }
}