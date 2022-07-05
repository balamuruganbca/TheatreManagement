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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.entity.Screen;
import com.example.theatremanagement.entity.Seat;
import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.exception.TheatreNotFoundException;
import com.example.theatremanagement.service.MovieService;
import com.example.theatremanagement.service.TheatreService;

@RestController  //The RestController allows to handle all REST APIs.
@RequestMapping("/apc")  //used to map web requests onto specific handler classes/methods.

public class TheatreController {
	
	

	private TheatreService theatreService;
	
		@Autowired
		public TheatreController(TheatreService theTheatreService)
		{
			theatreService=theTheatreService;
		}
		

		@GetMapping("/theatres")  ////maps HTTP GET requests onto specific handler methods.
		public List<Theatre> getAllTeatres()
		{
			List<Theatre> theTheatre=theatreService.findAll();
			
			return theTheatre;
			
		}
		
		@GetMapping("/theatres/{theatreId}")
		public Theatre getTheatreById(@PathVariable int theatreId) throws TheatreNotFoundException
		{
			Theatre theatre=theatreService.findById(theatreId);
			return theatre;
			
		}
		
		
		@PostMapping("/theatres") //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public Theatre addTheatre(@RequestBody Theatre theTheatre)
		{
			theTheatre.setTheatreId(0);
			theatreService.save(theTheatre);
			return theTheatre;
			
		}
		
		@PutMapping("/theatres")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public Theatre updateTheatres(@RequestBody Theatre theTheatre)
		{
			
			theatreService.save(theTheatre);
			
			return theTheatre;
			
		}
		
		@DeleteMapping("/theatres/{theatreId}")  //HTTP DELETE requests onto specific handler methods
		public String deleteTheatreById(@PathVariable int theatreId) throws TheatreNotFoundException
		{
			String theTheatre=theatreService.deleteById(theatreId);
			return theTheatre;
			
			
			
		}

}