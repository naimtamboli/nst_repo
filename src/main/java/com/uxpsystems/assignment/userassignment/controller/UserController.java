package com.uxpsystems.assignment.userassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.uxpsystems.assignment.userassignment.model.User;
import com.uxpsystems.assignment.userassignment.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	 * Below REST APIs are called from web application to load jsp pages
	 */
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView showAddUserPage(@ModelAttribute("adduser") User adduser, BindingResult result){
    	ModelAndView mv = new ModelAndView();
        mv.addObject("adduser", adduser);  
        return mv;
    }
    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.GET)
    public ModelAndView showUpdateUserPage(@PathVariable Long id){
    	User updateUser = userService.getUserDetails(id);
    	ModelAndView model = new ModelAndView();
        model.addObject("updateUser", updateUser); 
        model.setViewName("updateuser");
        return model;
    }
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public ModelAndView showDeleteUserPage(@PathVariable String id){
    	ModelAndView model = new ModelAndView();
    	model.addObject("id", id);
        model.setViewName("deleteuser");
        return model;
    }
	
	
	/*
	 * Below REST APIs called from web application with spring security for user CRUD operations
	 */
	
	@GetMapping(value = "/user")
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	model.addObject("users", userService.getAllUserDetails());
    	model.setViewName("dashboard");
    	return model;
    }
	
	@PostMapping(value = "/user")
	public ModelAndView addUser(@ModelAttribute("adduser") User adduser, BindingResult 
	result) {
		userService.createUser(adduser);
		ModelAndView model = new ModelAndView();
    	model.addObject("users", userService.getAllUserDetails());
    	model.setViewName("dashboard");
    	return model;
	}
	
	@PutMapping("/user")
	public void updateUser(@ModelAttribute("updateUser") User updateUser, BindingResult 
			result) {
		userService.updateUser(updateUser);
	}
    
    
	
	/*
	 * Below REST APIs called from POSTMAN without spring security for user CRUD operations
	 * When using these APIs, comment above APIs for web application and comment SpringSecurityConfig.java and 
	 * spring-boot-starter-security dependency in pom.xml
	 */
	
	
	
//	@GetMapping(value = "/user")
//	public ResponseEntity<List<User>> getAllUserDetails() {
//        
//		List userDetails = userService.getAllUserDetails();
//		return new ResponseEntity <List<User>>(userDetails, HttpStatus.OK);
//	}
//
//	@GetMapping("/user/{id}")
//	public ResponseEntity<User> userDetails(@PathVariable Long id) {
//        
//		User userDetails = userService.getUserDetails(id);
//		return new ResponseEntity <User>(userDetails, HttpStatus.OK);
//	}
//	
//	@PostMapping("/user")
//	public void createUser(@RequestBody User user) {
//		userService.createUser(user);
//	}
//	
//	@PutMapping("/user")
//	public void updateUser(@RequestBody User user) {
//		userService.updateUser(user);
//	}
//	
//	@DeleteMapping("/user/{id}")
//		public void deleteUser(@PathVariable Long id) {
//			userService.deleteUser(id);
//			
//		}
	}
	
