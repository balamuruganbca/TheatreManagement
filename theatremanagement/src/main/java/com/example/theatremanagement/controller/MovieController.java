package com.example.theatremanagement.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.exception.MovieNotFoundException;
import com.example.theatremanagement.service.MovieService;
@RestController   //The RestController allows to handle all REST APIs.

@RequestMapping("/api") //used to map web requests onto specific handler classes/methods

public class MovieController {

	private MovieService movieService;
	
		@Autowired   //used for dependency injection
		public MovieController(MovieService theMovieService)
		{
			movieService=theMovieService;
		}
		

		@GetMapping("/movies")    //maps HTTP GET requests onto specific handler methods.
		public List<Movie> listMovies()
		{
			List<Movie> theMovies=movieService.findAll();
			
			return theMovies;
			
		}
		
		@GetMapping("/movies/{movieId}")
		public Movie findMovieById(@PathVariable int movieId) throws MovieNotFoundException
		{
			Movie movie=movieService.findById(movieId);
			return movie;
			
		}
		
		
		/*@GetMapping("/movies/{rating}")
		public List<Movie> findAllByOrderByRatingAsc(@PathVariable double rating) throws MovieNotFoundException
		{
			List<Movie> movie=movieService.findAllByOrderByRatingAsc(rating); 

			return movie;
			
		}*/
		
		
		
		
		
		@PostMapping("/movies")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public Movie addMovies(@RequestBody Movie theMovie)
		{
			theMovie.setMovieId(0);
			
			movieService.save(theMovie);
			
			return theMovie;
			
		}
		
		@PutMapping("/movies")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
		public Movie updateMovies(@RequestBody Movie theMovie)
		{
			
			movieService.save(theMovie);
			
			return theMovie;
			
		}
		
		
		
		@DeleteMapping("/movies/{movieId}")  //HTTP DELETE requests onto specific handler methods
		public String deleteMovie(@PathVariable("movieId") int movieId) throws MovieNotFoundException
		{
			
			
			
			String deletedItem=movieService.deleteById(movieId);
			
			return  deletedItem;
			
		}
		
	}
