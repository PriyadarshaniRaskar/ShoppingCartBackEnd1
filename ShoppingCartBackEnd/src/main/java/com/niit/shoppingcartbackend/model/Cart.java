package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "cart")
@Component
public class Cart {
	@Id
	private String CartProductId;
	private String CartProductName;
	private String CartProductUser;
	private double CartProductPrice;

	public String getCartProductId() {
		return CartProductId;
	}

	public void setCartProductId(String cartProductId) {
		CartProductId = cartProductId;
	}

	public String getCartProductName() {
		return CartProductName;
	}

	public void setCartProductName(String cartProductName) {
		CartProductName = cartProductName;
	}

	public String getCartProductUser() {
		return CartProductUser;
	}

	public void setCartProductUser(String cartProductUser) {
		CartProductUser = cartProductUser;
	}

	public double getCartProductPrice() {
		return CartProductPrice;
	}

	public void setCartProductPrice(double cartProductPrice) {
		CartProductPrice = cartProductPrice;
	}
}
