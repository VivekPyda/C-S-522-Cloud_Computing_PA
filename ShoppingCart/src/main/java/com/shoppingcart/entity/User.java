package com.shoppingcart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;

	@Column(name = "Username")
	private String userName;

	@Column(name = "Userpassword")
	private String userPassword;

	@Column(name = "Userpreferences")
	private String userPreferences;

	public User() {
		// Default constructor required by JPA
	}

	public User(Long userID, String userName, String userPassword, String userPreferences) {
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPreferences = userPreferences;
	}

	// Getters and Setters

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(String userPreferences) {
		this.userPreferences = userPreferences;
	}
}
