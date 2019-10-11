package com.rollingstone.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROLLINGSTONE_CART_ITEM")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="OFFER_ID", nullable = false)
	private Long offerId;
	
	@Column(name ="PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Column(name ="QUANTITY", nullable = false)
	private int quantity;
	
	@Column(name ="UNIT", nullable = false)
	private String unit;
	
	@Column(name ="PRICE", nullable = false)
	private Double price;
	
	@Column(name ="FFM_TYPE", nullable = false)
	private String ffmType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CART_ID", nullable = false)
	@JsonIgnore
	private Cart cart;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFfmType() {
		return ffmType;
	}

	public void setFfmType(String ffmType) {
		this.ffmType = ffmType;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartItem(long id, Long offerId, Long productId, int quantity, String unit, Double price, String ffmType,
			Cart cart) {
		super();
		this.id = id;
		this.offerId = offerId;
		this.productId = productId;
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.ffmType = ffmType;
		this.cart = cart;
	}

	public CartItem() {
		super();
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", offerId=" + offerId + ", productId=" + productId + ", quantity=" + quantity
				+ ", unit=" + unit + ", price=" + price + ", ffmType=" + ffmType + ", cart=" + cart + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((ffmType == null) ? 0 : ffmType.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((offerId == null) ? 0 : offerId.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		CartItem other = (CartItem) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (ffmType == null) {
			if (other.ffmType != null)
				return false;
		} else if (!ffmType.equals(other.ffmType))
			return false;
		if (id != other.id)
			return false;
		if (offerId == null) {
			if (other.offerId != null)
				return false;
		} else if (!offerId.equals(other.offerId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity != other.quantity)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	
	
	
}
