package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Cart;

public class CartEvent extends ApplicationEvent {

	private String eventType;
	private Cart cart;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public CartEvent(Object source, String eventType, Cart cart) {
		super(source);
		this.eventType = eventType;
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "CartEvent [eventType=" + eventType + ", cart=" + cart + "]";
	}
	
	
	
}
