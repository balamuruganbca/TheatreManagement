package com.example.theatremanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.entity.User;
import com.example.theatremanagement.exception.TheatreNotFoundException;
import com.example.theatremanagement.exception.UserNotFoundException;
import com.example.theatremanagement.service.UserService;

@RestController  //The RestController allows to handle all REST APIs.

@RequestMapping("/apd")  //used to map web requests onto specific handler classes/methods.
public class UserController 
{
		private UserService userService;
		
		@Autowired
		public UserController(UserService userService) {
	        this.userService = userService;
	    } 
		
		@GetMapping("/users")  //maps HTTP GET requests onto specific handler methods.
	    public List<User> getAllUsers() {
	        return userService.findAll();
	    }
		
		@GetMapping("/users/{userId}")
		public User getUserById(@PathVariable int userId) throws Exception
		{
			User user=userService.findById(userId);
			return user;
			
		}
		@PostMapping("/users")  //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public User save(@Valid @RequestBody User theUser)
		{
			theUser.setUserId(0);
		    theUser=userService.save(theUser);
			return theUser;
			
		}
		
		@PutMapping("/users")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public User updateUsers(@RequestBody User theUser)
		{
			
			userService.save(theUser);
			
			return theUser;
			
		}
		
		@GetMapping("/userByEmail/{email}")
		public User getUserByEmail(@PathVariable String email)
		{
			System.out.println(email);
			User user=userService.findUserByEmail(email);
			return user;
			
		}
		
		@GetMapping("/userByName/{userName}")  
		public User getByUserName(@PathVariable String userName)
		{
			User user=userService.findByUserName(userName);
			return user;
			
		}
		
		
		@DeleteMapping("/users/{userId}")
		public String deleteUser(@PathVariable int userId) throws UserNotFoundException
		{
			String str=userService.deleteById(userId);
			return str;
		}
		
		
}