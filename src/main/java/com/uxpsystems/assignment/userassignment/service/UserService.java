package com.uxpsystems.assignment.userassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uxpsystems.assignment.userassignment.dao.UserDao;
import com.uxpsystems.assignment.userassignment.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserDetails(Long id) {
		User user = userDao.getUserDetails(id);
		return user;
	}
	
	public List<User> getAllUserDetails() {
		return userDao.getAllUserDetails();
	}
	
	public String createUser(User user) {
		userDao.createUser(user);
		return null;
    }

	public void updateUser(User user) {
		userDao.updateUser(user);
    }

	public void deleteUser(Long id) {
    	userDao.deleteUser(id);
    } 
	
}