package com.myboot.DraftECommerceApp.info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyControllerFromScratch {

	
	@GetMapping("/")
	public String doGetter() {
		return "Wie rife sind die Orangen?";
	}
	
	
}
