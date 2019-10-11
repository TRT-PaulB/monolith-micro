package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.StorePickUpEvent;

@Component
public class StorePickUpEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(StorePickUpEvent spuEvent) {
		log.info("Received SPU Event : "+spuEvent.getEventType());
		log.info("Received SPU From SPU Event :"+spuEvent.getSpu().toString());
	}
}
