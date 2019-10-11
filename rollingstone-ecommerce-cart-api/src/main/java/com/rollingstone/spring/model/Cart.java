package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROLLINGSTONE_CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="CART_TOTAL", nullable = false)
	private Double cartTotal;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CART_DATE", unique = false, nullable = false, length = 10)
	private Date cartDate;
	
	@OneToOne
	@JoinColumn(name="USER_PROFILE_ID")
	private User user;
	
/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart")
	//@OneToMany(mappedBy = "cart")
	private Set<CartItem> cartItems = new HashSet<CartItem>();*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(Double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public Date getCartDate() {
		return cartDate;
	}

	public void setCartDate(Date cartDate) {
		this.cartDate = cartDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

/*	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}*/

	public Cart(long id, Double cartTotal, Date cartDate, User user) { //, Set<CartItem> cartItems) {
		super();
		this.id = id;
		this.cartTotal = cartTotal;
		this.cartDate = cartDate;
		this.user = user;
		//this.cartItems = cartItems;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartTotal=" + cartTotal + ", cartDate=" + cartDate + ", user=" + user
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartDate == null) ? 0 : cartDate.hashCode());
		result = prime * result + ((cartTotal == null) ? 0 : cartTotal.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Cart other = (Cart) obj;
		if (cartDate == null) {
			if (other.cartDate != null)
				return false;
		} else if (!cartDate.equals(other.cartDate))
			return false;
		if (cartTotal == null) {
			if (other.cartTotal != null)
				return false;
		} else if (!cartTotal.equals(other.cartTotal))
			return false;
		if (id != other.id)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
}
