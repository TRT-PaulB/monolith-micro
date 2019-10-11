package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.AccountEvent;

@Component
public class AccountEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(AccountEvent accountEvent) {
		log.info("Received Account Event : "+accountEvent.getEventType());
		log.info("Received Account From Account Event :"+accountEvent.getAccount().toString());
	}
}
