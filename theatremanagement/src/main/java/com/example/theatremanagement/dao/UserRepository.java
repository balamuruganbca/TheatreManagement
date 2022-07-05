package com.example.theatremanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> 
{
	

	public User findUserByEmail(String email);


	public User findByUserName(String userName);

	
}
