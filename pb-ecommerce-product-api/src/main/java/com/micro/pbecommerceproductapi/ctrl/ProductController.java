package com.micro.pbecommerceproductapi.ctrl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.micro.pbecommerceproductapi.dm.Product;
import com.micro.pbecommerceproductapi.event.ProductEvent;
import com.micro.pbecommerceproductapi.service.ProductService;

@RestController
public class ProductController extends AbstractController {

   @Autowired
   private ProductService  productService;

   
   public ProductController(ProductService  productService) {
	  this.productService = productService; 
   }
   
   /*---Add new Product---*/
// WAS
   //   @PostMapping("/product")
//   public ResponseEntity<?> save(@RequestBody Product product) {
//      long id = productService.save(product);
//      return ResponseEntity.ok().body("New Product has been saved with ID:" + id);
//   }
   @PostMapping("/product")
   public ResponseEntity<?> createProduct(@RequestBody Product product) {
      Product savedProduct = productService.save(product);
      
      // TODO handling exceptions.....???
      
      ProductEvent prdCreatedEvent = new ProductEvent("Product is created", savedProduct);
      eventPublisher.publishEvent(prdCreatedEvent);
      
      return ResponseEntity.ok().body("New Product has been saved with ID: " + savedProduct.getId());
   }
   
   
   /*---Get a Product by id---*/
   @GetMapping("/product/{id}")
// WAS
//   public ResponseEntity<Product> get(@PathVariable("id") long id) {
//	   Product product = productService.get(id);
//      return ResponseEntity.ok().body(product);
//   }
// needs refactoring to handle optional better....   
 public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
   checkResourceFound(this.productService.get(id));	   
   Optional<Product> product = productService.get(id);
   
   
   
   // TODO handle blank product properly  
   ProductEvent prdCreatedEvent = new ProductEvent("One product is retrieved", product.get());
   eventPublisher.publishEvent(prdCreatedEvent);
   
   return ResponseEntity.ok().body(product.get());
}
 
   
   /*---get all Products---*/
   @GetMapping("/product")
// WAS
//   public ResponseEntity<List<Product>> list() {
//      List<Product> categories = productService.list();
//      return ResponseEntity.ok().body(categories);
//   }
   public @ResponseBody Page<Product> getProductsByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
     Page<Product> pagedProducts = productService.getProductsByPage(pageNumber, pageSize);
     return pagedProducts;
  }
   
   
   /*---Update a Product by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	  checkResourceFound(this.productService.get(id));
      productService.update(product);
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   
   /*---Delete a Product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
	  checkResourceFound(this.productService.get(id));
      productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
}