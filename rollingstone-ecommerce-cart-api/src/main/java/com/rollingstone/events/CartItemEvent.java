package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.CartItem;

public class CartItemEvent extends ApplicationEvent {

	private String eventType;
	private CartItem cart;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	public CartItem getCartItem() {
		return cart;
	}
	public void setCartItem(CartItem cart) {
		this.cart = cart;
	}
	public CartItemEvent(Object source, String eventType, CartItem cart) {
		super(source);
		this.eventType = eventType;
		this.cart = cart;
	}
	@Override
	public String toString() {
		return "CartItemEvent [eventType=" + eventType + ", cart=" + cart + "]";
	}
	
	
	
}
