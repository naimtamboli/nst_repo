package com.uxpsystems.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserDao;
import com.uxpsystems.assignment.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	
	public List<User> getAllUsers() {
		List<User> topics = new ArrayList<User>();
		userDao.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<User> getUser(String id) {
		return userDao.findById(id);
	}
	
	public void addUser(User topic) {
		userDao.save(topic);
	}
	
	public void updateUser(String id, User topic) {
		userDao.save(topic);
	}
	
	public void deleteUser(String id) {
		userDao.deleteById(id);
	}
	

}
