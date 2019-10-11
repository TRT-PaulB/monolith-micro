package com.rollingstone.serializer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rollingstone.spring.model.Order;
import com.rollingstone.spring.model.ROOrder;

@JsonComponent
public class OrderJsonSerializer extends JsonSerializer<Order> {

	Logger logger  = LoggerFactory.getLogger("OrderJsonSerializer");
	
	@Override
    public void serialize(Order order, JsonGenerator jsonGenerator, 
      SerializerProvider serializerProvider) throws IOException, 
      JsonProcessingException {
		
		logger.info("Inside the OrderJsonSerializer");
		 jsonGenerator.writeStartObject();
		 
		 
	
		 jsonGenerator.writeNumberField("id", order.getId());
		 jsonGenerator.writeStringField("orderNumber", order.getOrderNumber());
		 
		 jsonGenerator.writeStringField("orderTrackingNumber", order.getOrderTrackingNumber());
		 jsonGenerator.writeStringField("accountNumber", order.getOrderNumber());

		 jsonGenerator.writeNumberField("orderTotal", order.getOrderTotal());
		 jsonGenerator.writeStringField("orderDate", order.getOrderDate().toLocaleString());
	
		 jsonGenerator.writeStringField("userName", order.getUser().getUserName());
		 jsonGenerator.writeStringField("firstName", order.getUser().getFirstName());
		 jsonGenerator.writeStringField("lastName", order.getUser().getLastName());
		 jsonGenerator.writeStringField("memberType", order.getUser().getMemberType());
		 
		 jsonGenerator.writeStringField("shippingHouseNumber", order.getShippingAddress().getHouseNumber());
		 jsonGenerator.writeStringField("shippingStreetAddress", order.getShippingAddress().getStreetAddress());
		 jsonGenerator.writeStringField("shippingCity", order.getShippingAddress().getCity());
		 jsonGenerator.writeStringField("shippingState", order.getShippingAddress().getState());
		 jsonGenerator.writeStringField("shippingZipCode", order.getShippingAddress().getZipCode());
		 
		 jsonGenerator.writeStringField("billingHouseNumber", order.getBillingAddress().getHouseNumber());
		 jsonGenerator.writeStringField("billingCity", order.getBillingAddress().getCity());
		 jsonGenerator.writeStringField("billingState", order.getBillingAddress().getState());
		 jsonGenerator.writeStringField("billingZipCode", order.getBillingAddress().getZipCode());

	

		 
		 logger.info("Inside the OrderJsonSerializer id "+order.getId());
		 logger.info("Inside the OrderJsonSerializer order.getOrderTotal() "+order.getOrderTotal());

		 jsonGenerator.writeEndObject();
	    }
   
}
