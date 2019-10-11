package com.rollingstone.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROLLINGSTONE_PROMO")
public class Promo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="PRODUCT_CODE", nullable = false)
	private String productCode;
	
	@Column(name ="PROMO_CODE", nullable = false)
	private String promoCode;
	
	@Column(name ="PROMO_NAME", nullable = false)
	private String promoName;
	
	@Column(name ="PROMO_TITLE", nullable = false)
	private String promoTitle;
	
	@Column(name ="PROMO_DETAILS", nullable = false)
	private String promoDetails;
	
	@Column(name ="STATUS", nullable = false)
	private String status;
	
	@Column(name ="DISCOUNT_AMOUNT", nullable = false)
	private Double discountAmount;
	
	@Column(name ="DISCOUNT_TYPE", nullable = false)
	private String discountType;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="START_DATE", nullable = false, unique = false, length = 10)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="END_DATE", nullable = false, unique = false, length = 10)
	private Date endDate;
	
	@Column(name ="MIN_PURCHASE_VALUE", nullable = false)
	private Double minimumPurchaseValue;

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

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public String getPromoTitle() {
		return promoTitle;
	}

	public void setPromoTitle(String promoTitle) {
		this.promoTitle = promoTitle;
	}

	public String getPromoDetails() {
		return promoDetails;
	}

	public void setPromoDetails(String promoDetails) {
		this.promoDetails = promoDetails;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getMinimumPurchaseValue() {
		return minimumPurchaseValue;
	}

	public void setMinimumPurchaseValue(Double minimumPurchaseValue) {
		this.minimumPurchaseValue = minimumPurchaseValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Promo() {
		super();
	}

	public Promo(long id, String productCode, String promoCode, String promoName, String promoTitle,
			String promoDetails, String status, Double discountAmount, String discountType, Date startDate,
			Date endDate, Double minimumPurchaseValue) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.promoCode = promoCode;
		this.promoName = promoName;
		this.promoTitle = promoTitle;
		this.promoDetails = promoDetails;
		this.status = status;
		this.discountAmount = discountAmount;
		this.discountType = discountType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minimumPurchaseValue = minimumPurchaseValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountAmount == null) ? 0 : discountAmount.hashCode());
		result = prime * result + ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((minimumPurchaseValue == null) ? 0 : minimumPurchaseValue.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((promoCode == null) ? 0 : promoCode.hashCode());
		result = prime * result + ((promoDetails == null) ? 0 : promoDetails.hashCode());
		result = prime * result + ((promoName == null) ? 0 : promoName.hashCode());
		result = prime * result + ((promoTitle == null) ? 0 : promoTitle.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Promo other = (Promo) obj;
		if (discountAmount == null) {
			if (other.discountAmount != null)
				return false;
		} else if (!discountAmount.equals(other.discountAmount))
			return false;
		if (discountType == null) {
			if (other.discountType != null)
				return false;
		} else if (!discountType.equals(other.discountType))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (minimumPurchaseValue == null) {
			if (other.minimumPurchaseValue != null)
				return false;
		} else if (!minimumPurchaseValue.equals(other.minimumPurchaseValue))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (promoCode == null) {
			if (other.promoCode != null)
				return false;
		} else if (!promoCode.equals(other.promoCode))
			return false;
		if (promoDetails == null) {
			if (other.promoDetails != null)
				return false;
		} else if (!promoDetails.equals(other.promoDetails))
			return false;
		if (promoName == null) {
			if (other.promoName != null)
				return false;
		} else if (!promoName.equals(other.promoName))
			return false;
		if (promoTitle == null) {
			if (other.promoTitle != null)
				return false;
		} else if (!promoTitle.equals(other.promoTitle))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Promo [id=" + id + ", productCode=" + productCode + ", promoCode=" + promoCode + ", promoName="
				+ promoName + ", promoTitle=" + promoTitle + ", promoDetails=" + promoDetails + ", status=" + status
				+ ", discountAmount=" + discountAmount + ", discountType=" + discountType + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", minimumPurchaseValue=" + minimumPurchaseValue + "]";
	}


	
}
