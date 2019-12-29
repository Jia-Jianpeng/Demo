package com.jjp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjp.model.User;
import com.jjp.repository.UserRepository;
import com.jjp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User getUser(int uid) {
		Optional<User> optional = userRepository.findById(uid);
		User user = optional.get();
		return user;
	}

}
