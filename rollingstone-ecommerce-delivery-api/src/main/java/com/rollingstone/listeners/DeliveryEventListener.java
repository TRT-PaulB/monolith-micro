package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.DeliveryEvent;

@Component
public class DeliveryEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(DeliveryEvent deliveryEvent) {
		log.info("Received Delivery Event : "+deliveryEvent.getEventType());
		log.info("Received Delivery From Delivery Event :"+deliveryEvent.getDelivery().toString());
	}
}
