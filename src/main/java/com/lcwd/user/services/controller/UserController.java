package com.lcwd.user.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.services.entity.User;
import com.lcwd.user.services.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userService;
	
	// create
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return new ResponseEntity<User>(user1, HttpStatus.CREATED);
	}
	
	// single user get
	
	@GetMapping("/{userId}") // when you use dynamic get mapping userId name same with handler method userId name then you don't need to use @pathvariable ("userId").
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return new  ResponseEntity<>(user, HttpStatus.OK);
	}
	
	// all user get
	
	@GetMapping
	public ResponseEntity<List<User>> getAlluser(){
		List<User> list = userService.getAllUser();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
}
