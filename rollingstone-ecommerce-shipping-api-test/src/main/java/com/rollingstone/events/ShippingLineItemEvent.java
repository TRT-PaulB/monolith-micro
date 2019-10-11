package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Shipping;
import com.rollingstone.spring.model.ShippingLineItem;

public class ShippingLineItemEvent extends ApplicationEvent {

	private String eventType;
	private ShippingLineItem shippingLineItem;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public ShippingLineItem getShippingLineItem() {
		return shippingLineItem;
	}
	public void setShippingLineItem(ShippingLineItem shippingLineItem) {
		this.shippingLineItem = shippingLineItem;
	}
	public ShippingLineItemEvent(Object source, String eventType, ShippingLineItem shippingLineItem) {
		super(source);
		this.eventType = eventType;
		this.shippingLineItem = shippingLineItem;
	}
	@Override
	public String toString() {
		return "ShippingLineItemEvent [eventType=" + eventType + ", shippingLineItem=" + shippingLineItem + "]";
	}
	
	
}
