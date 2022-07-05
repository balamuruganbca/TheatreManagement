package com.example.theatremanagement.service;
import java.util.List;
import java.util.Optional;

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.entity.User;
import com.example.theatremanagement.exception.UserNotFoundException;



public interface UserService
{
	public List<User> findAll();
	
	public User findById(int userId) throws UserNotFoundException;

	public User save(User userId);

	public String deleteById(int userId) throws UserNotFoundException;
	
	public User findUserByEmail(String email);
	 

	public User findByUserName(String userName);	 
}