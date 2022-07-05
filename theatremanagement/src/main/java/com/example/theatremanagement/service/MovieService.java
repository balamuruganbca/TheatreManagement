package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.exception.MovieNotFoundException;

public interface MovieService 
{

		public List<Movie> findAll();

		public Movie findById(int movieId) throws MovieNotFoundException;

		public void save(Movie movieId);
		
		public String deleteById(int movieId) throws MovieNotFoundException;

		//public List<Movie> findAllByOrderByRatingAsc(double rating); 



	   
	}

	
	
	

