package com.shoppingcart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;

	@Column(name = "name")
	private String name;

	@Column(name = "decription")
	private String decription;

	@Column(name = "manufacturername")
	private String manufacturerName;

	@Column(name = "inventorycount")
	private int inventoryCount;

	public Product() {
		// Default constructor required by JPA
	}

	public Product(int productID, String name, String decription, String manufacturerName, int inventoryCount) {
		super();
		this.productID = productID;
		this.name = name;
		this.decription = decription;
		this.manufacturerName = manufacturerName;
		this.inventoryCount = inventoryCount;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public int getInventoryCount() {
		return inventoryCount;
	}

	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
}
