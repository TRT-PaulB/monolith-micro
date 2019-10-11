package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.CartEvent;

@Component
public class CartEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(CartEvent cartEvent) {
		log.info("Received Cart Event : "+cartEvent.getEventType());
		log.info("Received Cart From Cart Event :"+cartEvent.getCart().toString());
	}
}
