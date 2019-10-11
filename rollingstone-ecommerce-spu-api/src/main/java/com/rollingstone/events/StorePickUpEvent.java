package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.StorePickUp;

public class StorePickUpEvent extends ApplicationEvent {

	private String eventType;
	private StorePickUp spu;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public StorePickUp getSpu() {
		return spu;
	}
	public void setSpu(StorePickUp spu) {
		this.spu = spu;
	}
	public StorePickUpEvent(Object source, String eventType, StorePickUp spuSaved) {
		super(source);
		this.eventType = eventType;
		this.spu = spuSaved;
	}
	@Override
	public String toString() {
		return "UserEvent [eventType=" + eventType + ", spu=" + spu + "]";
	}
	
	
	
}
