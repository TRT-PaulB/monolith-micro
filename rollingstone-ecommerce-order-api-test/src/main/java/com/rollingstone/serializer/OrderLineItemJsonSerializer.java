package com.rollingstone.serializer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rollingstone.spring.model.OrderLineItem;
import com.rollingstone.spring.model.ROOrder;

@JsonComponent
public class OrderLineItemJsonSerializer extends JsonSerializer<OrderLineItem> {

	Logger logger = LoggerFactory.getLogger("OrderJsonSerializer");

	@Override
	public void serialize(OrderLineItem orderLineItem, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

		logger.info("Inside the OrderJsonSerializer");
		jsonGenerator.writeStartObject();

		jsonGenerator.writeNumberField("id", orderLineItem.getId());
		//jsonGenerator.writeStringField("orderNumber", orderLineItem.getOrder().getOrderNumber());
		jsonGenerator.writeNumberField("productId", orderLineItem.getProductId());
		jsonGenerator.writeStringField("UOM", orderLineItem.getUom());
		jsonGenerator.writeNumberField("UOM", orderLineItem.getUnitPrice());
		jsonGenerator.writeNumberField("Quanrtity", orderLineItem.getQuantityOrdered());

		jsonGenerator.writeEndObject();

	}

}
