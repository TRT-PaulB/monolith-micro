package com.micro.pbecommerceproductapi.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.micro.pbecommerceproductapi.event.ProductEvent;

@Component
public class ProductEventListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// this is an asynchronous hook - this event which is caught here
	// the system is not held back waiting for this to complete
	// usage might be after an order is placed......
	// this logging does not rely on an external system in any way
	@EventListener
	public void onApplicationEvent(ProductEvent productEvent) {
		logger.info("Received product event : " + productEvent.getEventType());
		logger.info("Received product from product event: " + productEvent.getProduct().toString());
	}
	
}
