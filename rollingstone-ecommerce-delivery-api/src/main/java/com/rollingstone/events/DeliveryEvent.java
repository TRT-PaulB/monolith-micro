package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Delivery;

public class DeliveryEvent extends ApplicationEvent {

	private String eventType;
	private Delivery delivery;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public DeliveryEvent(Object source, String eventType, Delivery delivery) {
		super(source);
		this.eventType = eventType;
		this.delivery = delivery;
	}
	@Override
	public String toString() {
		return "DeliveryEvent [eventType=" + eventType + ", Delivery=" + delivery + "]";
	}
	
	
	
}
