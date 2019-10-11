package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.CartItemEvent;

@Component
public class CartItemEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(CartItemEvent cartItemEvent) {
		log.info("Received CartItem Event : "+cartItemEvent.getEventType());
		log.info("Received CartItem From CartItem Event :"+cartItemEvent.getCartItem().toString());
	}
}
