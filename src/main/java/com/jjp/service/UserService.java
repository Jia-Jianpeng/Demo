package com.jjp.service;

import com.jjp.model.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(String email);
	
	public User getUser(int uid);
}
