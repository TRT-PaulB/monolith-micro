package com.rollingstone.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_PRICING")
public class Pricing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PCODE", nullable = false)
	private String productCode;
	
	@Column(name ="PRICE_ID", nullable = false)
	private String pricingId;
	
	@Column(name ="MEMBER_TYPE", nullable = false)
	private String memberType;
	
	@Column(name ="PRICE_TYPE", nullable = false)
	private String priceType;
	
	@Column(name ="LABEL", nullable = false)
	private Double discountAmount;
	
	@Column(name ="DISPLAY", nullable = false)
	private String display;
	
	@Column(name ="ORIG_PRICE", nullable = false)
	private Double originalPrice;

	@Column(name ="DISC_PRICE", nullable = false)
	private Double discountedPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getPricingId() {
		return pricingId;
	}

	public void setPricingId(String pricingId) {
		this.pricingId = pricingId;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Pricing(long id, String productCode, String pricingId, String memberType, String priceType,
			Double discountAmount, String display, Double originalPrice, Double discountedPrice) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.pricingId = pricingId;
		this.memberType = memberType;
		this.priceType = priceType;
		this.discountAmount = discountAmount;
		this.display = display;
		this.originalPrice = originalPrice;
		this.discountedPrice = discountedPrice;
	}

	public Pricing() {
		super();
	}

	@Override
	public String toString() {
		return "Pricing [id=" + id + ", productCode=" + productCode + ", pricingId=" + pricingId + ", memberType="
				+ memberType + ", priceType=" + priceType + ", discountAmount=" + discountAmount + ", display="
				+ display + ", originalPrice=" + originalPrice + ", discountedPrice=" + discountedPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountedPrice == null) ? 0 : discountedPrice.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((memberType == null) ? 0 : memberType.hashCode());
		result = prime * result + ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result + ((priceType == null) ? 0 : priceType.hashCode());
		result = prime * result + ((pricingId == null) ? 0 : pricingId.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pricing other = (Pricing) obj;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountedPrice == null) {
			if (other.discountedPrice != null)
				return false;
		} else if (!discountedPrice.equals(other.discountedPrice))
			return false;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (id != other.id)
			return false;
		if (memberType == null) {
			if (other.memberType != null)
				return false;
		} else if (!memberType.equals(other.memberType))
			return false;
		if (originalPrice == null) {
			if (other.originalPrice != null)
				return false;
		} else if (!originalPrice.equals(other.originalPrice))
			return false;
		if (priceType == null) {
			if (other.priceType != null)
				return false;
		} else if (!priceType.equals(other.priceType))
			return false;
		if (pricingId == null) {
			if (other.pricingId != null)
				return false;
		} else if (!pricingId.equals(other.pricingId))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}
	
	
	
	
}
