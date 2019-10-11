package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.PricingEvent;

@Component
public class PricingEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(PricingEvent pricingEvent) {
		log.info("Received Pricing Event : "+pricingEvent.getEventType());
		log.info("Received Pricing From Pricing Event :"+pricingEvent.getPricing().toString());
	}
}
