package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatremanagement.dao.UserRepository;
import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.entity.User;
import com.example.theatremanagement.exception.TheatreNotFoundException;
import com.example.theatremanagement.exception.UserNotFoundException;

@Service  //service annotation is used to perform service related tasks and it is present in service layer.
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired //used for dependency injection.
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public User findById(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> result=userRepository.findById(userId);

		
		User theUser=null;
		
		if(result.isPresent())
		{
			theUser=result.get();
		}
		else
		{
			throw new UserNotFoundException("Did not found user id-"+userId);
		}
		return theUser;
	}

	@Override
	public User save(User theUser) {
		return userRepository.save(theUser);
		
	}


	@Override //means that element to override the element declared in super class.
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}

	

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserName(userName);
		return user;
	}

	@Override
	public String deleteById(int userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> theUser = userRepository.findById(userId);
		
		// throw exception if null
		
		if (theUser.isEmpty()) {
			throw new UserNotFoundException("user id not found - " + userId);
		}
		
		userRepository.deleteById(userId);
		
		return "Deleted employee id - " + userId;
	}


	
	
}