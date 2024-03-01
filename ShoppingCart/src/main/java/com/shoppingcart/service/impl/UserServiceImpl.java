package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.entity.User;
import com.shoppingcart.repository.UserRepository;
import com.shoppingcart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

}
