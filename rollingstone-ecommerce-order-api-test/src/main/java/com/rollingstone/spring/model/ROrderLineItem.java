package com.rollingstone.spring.model;

public class ROrderLineItem {


	private Long id;
	
	
	private Long productId;
	
	private String productCode;
	
	int quantity;
	
	Double unitPrice;
	
	String unitOfMeasurement;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public ROrderLineItem(Long id, Long productId, String productCode, int quantity, Double unitPrice,
			String unitOfMeasurement) {
		super();
		this.id = id;
		this.productId = productId;
		this.productCode = productCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public ROrderLineItem() {
		super();
	}

	@Override
	public String toString() {
		return "ROrderLineItem [id=" + id + ", productId=" + productId + ", productCode=" + productCode + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", unitOfMeasurement=" + unitOfMeasurement + "]";
	}

	
	
	
}
