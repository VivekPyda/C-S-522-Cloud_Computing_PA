package com.shoppingcart.entity;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productbought")
public class ProductBought {
	@EmbeddedId
	private ProductBoughtID productBoughtID;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "UserID", referencedColumnName = "userID", insertable = false, updatable = false)
	private User user;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "ProductID", referencedColumnName = "productID", insertable = false, updatable = false)
	private Product product;

	@Column(name = "Username")
	private String userName;

	@Column(name = "Productname")
	private String productName;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Dateofpurchase")
	private Date dateOfPurchase;

	public ProductBoughtID getProductBoughtID() {
		return productBoughtID;
	}

	public void setProductBoughtID(ProductBoughtID productBoughtID) {
		this.productBoughtID = productBoughtID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
}
