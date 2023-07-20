package com.lcwd.user.services.services;

import java.util.List;

import com.lcwd.user.services.entity.User;

public interface UserService {

	// user operation
	
	// create user 
	public User saveUser(User user);
	
	// get all user
	public List<User> getAllUser();
	
	// get single user of given userId
	public User getUser(String userId);
	
	// TODO : delete
	// TODO : update
}
