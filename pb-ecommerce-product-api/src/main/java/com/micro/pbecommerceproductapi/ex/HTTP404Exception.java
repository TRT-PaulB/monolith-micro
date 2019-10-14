package com.micro.pbecommerceproductapi.ex;

public class HTTP404Exception extends RuntimeException {

	public HTTP404Exception() {
		super();
	}
	
	public HTTP404Exception(String msg) {
		super(msg);
	}
	
	public HTTP404Exception(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
