package com.shoppingcart.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductBoughtID implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productID;
	private int userID;

	public ProductBoughtID() {
		// Default constructor required by JPA
	}

	public ProductBoughtID(int productID, int userID) {
		this.productID = productID;
		this.userID = userID;
	}

	// Getters and setters for productID and userID

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
