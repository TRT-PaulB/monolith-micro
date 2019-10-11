package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.OrderEvent;

@Component
public class OrderEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(OrderEvent orderEvent) {
		log.info("Received Order Event : "+orderEvent.getEventType());
		log.info("Received Order From Order Event :"+orderEvent.getOrder().toString());
	}
}
