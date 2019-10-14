package com.micro.pbecommerceproductapi.ex;

public class RestAPIExceptionInfo {

	private final String msg;
	private final String details;
	
	
	public RestAPIExceptionInfo() {
		this.msg = null;
		this.details = null;
	}
	
	public RestAPIExceptionInfo(String msg, String details) {
		this.msg = msg;
		this.details = details;
	}
	
	
	
}
