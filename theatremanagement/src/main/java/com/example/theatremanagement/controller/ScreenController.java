package com.example.theatremanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatremanagement.entity.Screen;
import com.example.theatremanagement.exception.ScreenNotFoundException;
import com.example.theatremanagement.service.ScreenService;



@RestController //The RestController allows to handle all REST APIs.
@RequestMapping("/apa")  //used to map web requests onto specific handler classes/methods
public class ScreenController {

	private ScreenService screenService;
	
	@Autowired //used for dependency injection.
	public ScreenController(ScreenService theScreenService) {
		screenService = theScreenService;
	}
	
	// expose "/screens" and return list of employees
	@GetMapping("/screens")  //maps HTTP GET requests onto specific handler methods.
	public List<Screen> findAll() {
		return screenService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/screens/{screenId}")  //maps HTTP GET requests onto specific handler methods.
	public Screen getScreen(@PathVariable int screenId) throws ScreenNotFoundException  {
		
		Screen theScreen = screenService.findById(screenId);
		
		
		return theScreen;
	}
	
	// add mapping for POST /screens - add new screen
	
	@PostMapping("/screens")
	public Screen addScreen(@RequestBody Screen theScreen) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theScreen.setScreenId(0);
		
		screenService.save(theScreen);
		
		return theScreen;
	}
	
	// add mapping for PUT /screens - update existing screens.
	
	@PutMapping("/screens")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Screen updateScreens(@RequestBody Screen theScreen)
	{
		
		screenService.save(theScreen);
		
		return theScreen;
		
	}
	
	// add mapping for DELETE /screens/{screenId} - delete screen
	
	@DeleteMapping("/screens/{screenId}")
	public String deleteScreen(@PathVariable int screenId) throws ScreenNotFoundException {
		
		
		String theScreen=screenService.deleteById(screenId);
		
		return theScreen;
	}
	
}