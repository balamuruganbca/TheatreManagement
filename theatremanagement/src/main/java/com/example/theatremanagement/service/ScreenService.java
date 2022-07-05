package com.example.theatremanagement.service;


import java.util.List;

import com.example.theatremanagement.entity.Screen;
import com.example.theatremanagement.entity.Seat;
import com.example.theatremanagement.exception.ScreenNotFoundException;

public interface ScreenService {
	
	public List<Screen> findAll();
	
	public Screen findById(int screenId) throws ScreenNotFoundException;

	void save(Screen theScreen);

	String deleteById(int screenId) throws ScreenNotFoundException;
}