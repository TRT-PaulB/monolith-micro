package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Promo;

public class PromoEvent extends ApplicationEvent {

	private String eventType;
	private Promo promo;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Promo getPromo() {
		return promo;
	}
	public void setPromo(Promo promo) {
		this.promo = promo;
	}
	public PromoEvent(Object source, String eventType, Promo promo) {
		super(source);
		this.eventType = eventType;
		this.promo = promo;
	}
	@Override
	public String toString() {
		return "PromoEvent [eventType=" + eventType + ", promo=" + promo + "]";
	}
	
	
	
}
