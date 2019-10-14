package com.micro.pbecommerceproductapi.ex;

public class HTTP400Exception extends RuntimeException {

	public HTTP400Exception() {
		super();
	}
	
	public HTTP400Exception(String msg) {
		super(msg);
	}
	
	public HTTP400Exception(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
