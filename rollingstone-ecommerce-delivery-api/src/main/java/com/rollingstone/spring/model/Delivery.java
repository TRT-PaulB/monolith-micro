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
@Table(name = "ROLLINGSTONE_DELIVERY")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="OFFERID", nullable = false)
	private Long offerId;
	
	@Column(name ="PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name ="IS_AVAILABLE", nullable = false)
	private boolean isAvailable;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AVAILABLE_DATE", unique = true, nullable = false, length = 10)
	private Date availableDate;
	
	@Column(name ="DAYS_IN_TRANSIT", nullable = false)
	private int daysInTransit;
	
	@Column(name ="DELIVERY_CHARGE", nullable = false)
	private Double deliveryCharge;
	
	@Column(name ="IS_FREE_FOR_MEMBERS", nullable = false)
	private boolean isFreeForMembers;
	
	@Column(name ="HAUL_AWAY_MESSAGE", nullable = false)
	private String haulAwayMessage;
	
	@Column(name ="HAS_SPECIAL_OFFERS", nullable = false)
	private boolean hasSpecialOffers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public int getDaysInTransit() {
		return daysInTransit;
	}

	public void setDaysInTransit(int daysInTransit) {
		this.daysInTransit = daysInTransit;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public boolean isFreeForMembers() {
		return isFreeForMembers;
	}

	public void setFreeForMembers(boolean isFreeForMembers) {
		this.isFreeForMembers = isFreeForMembers;
	}

	public String getHaulAwayMessage() {
		return haulAwayMessage;
	}

	public void setHaulAwayMessage(String haulAwayMessage) {
		this.haulAwayMessage = haulAwayMessage;
	}

	public boolean isHasSpecialOffers() {
		return hasSpecialOffers;
	}

	public void setHasSpecialOffers(boolean hasSpecialOffers) {
		this.hasSpecialOffers = hasSpecialOffers;
	}

	public Delivery(long id, Long offerId, Long productId, boolean isAvailable, Date availableDate, int daysInTransit,
			Double deliveryCharge, boolean isFreeForMembers, String haulAwayMessage, boolean hasSpecialOffers) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.productId = productId;
		this.isAvailable = isAvailable;
		this.availableDate = availableDate;
		this.daysInTransit = daysInTransit;
		this.deliveryCharge = deliveryCharge;
		this.isFreeForMembers = isFreeForMembers;
		this.haulAwayMessage = haulAwayMessage;
		this.hasSpecialOffers = hasSpecialOffers;
	}

	public Delivery() {
		super();
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", offerId=" + offerId + ", productId=" + productId + ", isAvailable="
				+ isAvailable + ", availableDate=" + availableDate + ", daysInTransit=" + daysInTransit
				+ ", deliveryCharge=" + deliveryCharge + ", isFreeForMembers=" + isFreeForMembers + ", haulAwayMessage="
				+ haulAwayMessage + ", hasSpecialOffers=" + hasSpecialOffers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availableDate == null) ? 0 : availableDate.hashCode());
		result = prime * result + daysInTransit;
		result = prime * result + ((deliveryCharge == null) ? 0 : deliveryCharge.hashCode());
		result = prime * result + (hasSpecialOffers ? 1231 : 1237);
		result = prime * result + ((haulAwayMessage == null) ? 0 : haulAwayMessage.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + (isFreeForMembers ? 1231 : 1237);
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Delivery other = (Delivery) obj;
		if (availableDate == null) {
			if (other.availableDate != null)
				return false;
		} else if (!availableDate.equals(other.availableDate))
			return false;
		if (daysInTransit != other.daysInTransit)
			return false;
		if (deliveryCharge == null) {
			if (other.deliveryCharge != null)
				return false;
		} else if (!deliveryCharge.equals(other.deliveryCharge))
			return false;
		if (hasSpecialOffers != other.hasSpecialOffers)
			return false;
		if (haulAwayMessage == null) {
			if (other.haulAwayMessage != null)
				return false;
		} else if (!haulAwayMessage.equals(other.haulAwayMessage))
			return false;
		if (id != other.id)
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (isFreeForMembers != other.isFreeForMembers)
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
	
	
	
	
}
