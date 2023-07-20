package com.lcwd.user.services.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.services.entity.Rating;
import com.lcwd.user.services.entity.User;
import com.lcwd.user.services.exception.ResourceNotFoundException;
import com.lcwd.user.services.repository.UserRepository;
import com.lcwd.user.services.services.UserService;
import com.mysql.cj.log.LogFactory;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	// logger
	@Autowired
	private Logger logger=(java.util.logging.Logger) LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public User saveUser(User user) {
		
		// generate unique userId in the form of string.
		
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository.
	User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
	  /// fetch rating for above user from rating service.
	
	// http://localhost:8083/ratings/users/2c4604d9-e955-4c50-995b-3bf2d6d75d8c
	
	ArrayList<Rating> forobject=restTemplate.getForObject("http://localhost:8083/ratings/users/2c4604d9-e955-4c50-995b-3bf2d6d75d8c",ArrayList.class);
	logger.info("forobject");
	return user;
	}

}
