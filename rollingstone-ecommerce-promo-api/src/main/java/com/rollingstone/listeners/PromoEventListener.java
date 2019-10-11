package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.PromoEvent;

@Component
public class PromoEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(PromoEvent promoEvent) {
		log.info("Received Promo Event : "+promoEvent.getEventType());
		log.info("Received Promo From Promo Event :"+promoEvent.getPromo().toString());
	}
}
