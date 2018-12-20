package com.uxpsystems.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.dto.User;
import com.uxpsystems.assignment.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/user")
	public List<User> getAllUsers() {
		logger.debug("I am in getAllUsers");
		return userService.getAllUsers();
	}
	
	@RequestMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable String id) {
		logger.debug("I am in updateUser");
		userService.updateUser(id, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/user/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
}
