package com.shoppingcart.service;

import java.util.List;

import com.shoppingcart.entity.User;

public interface UserService {
	List<User> getAllUsers();

	User saveUser(User user);
	
	void deleteUserById(Long id);
}
