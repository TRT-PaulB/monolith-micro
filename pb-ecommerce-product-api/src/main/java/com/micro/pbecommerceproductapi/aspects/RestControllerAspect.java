package com.micro.pbecommerceproductapi.aspects;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;


@Aspect
@Component
public class RestControllerAspect {

	private final Logger logger = LoggerFactory.getLogger("RestControllerAspect");
	
	// these counter just has a unique name field it seems
	Counter productCreatedCounter = Metrics.counter("com.micro.pbecommerceproductapi.product.created");
	
	@Before("execution(public * com.micro.pbecommerceproductapi.ctrl.*Controller.*(..))")
	public void generalAllMethodAspect() {
		logger.info("All Method Calls invoke his general aspect method");
	}
	
	@AfterReturning("execution(public * com.micro.pbecommerceproductapi.ctrl.*Controller.createProduct(..))")
	public void getsCalledOnProductSave() {
		logger.info("This aspect is fired after the save method of the controller has returned");
		productCreatedCounter.increment();
	}
	
	
}
