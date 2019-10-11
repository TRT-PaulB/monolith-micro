package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.ShippingLineItemEvent;

@Component
public class ShippingLineItemEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(ShippingLineItemEvent shippingLineItemEvent) {
		log.info("Received ShippingLineItem Event : "+shippingLineItemEvent.getEventType());
		log.info("Received ShippingLineItem From ShippingLineItemEvent :"+shippingLineItemEvent.getShippingLineItem().toString());
	}
}
