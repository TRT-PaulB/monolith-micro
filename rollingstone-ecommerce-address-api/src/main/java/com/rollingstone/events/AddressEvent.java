package com.rollingstone.events;


import org.springframework.context.ApplicationEvent;

import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.AddressDTO;

public class AddressEvent extends ApplicationEvent {

	private String eventType;
	private AddressDTO address;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	
	
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	
	public AddressEvent(Object source, String eventType, AddressDTO address) {
		super(source);
		this.eventType = eventType;
		this.address = address;
	}
	@Override
	public String toString() {
		return "AddressEvent [eventType=" + eventType + ", address=" + address + "]";
	}
	
}
