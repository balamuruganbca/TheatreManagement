package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatremanagement.dao.MovieRepository;
import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.exception.MovieNotFoundException;

@Service  //used to mark class as a service provider .and provides business functionalities.

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired  //used for dependency injection.
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(int movieId) throws MovieNotFoundException  {
		// TODO Auto-generated method stub
		Optional<Movie> result=movieRepository.findById(movieId);
		
		Movie theMovie=null;
		
		if(result.isPresent())
		{
			theMovie=result.get();
		}
		else
		{
			throw  new MovieNotFoundException("Did not found Movie id-"+movieId);
		}
		return theMovie;
	}

	@Override
	public void save(Movie movieId) {
		// TODO Auto-generated method stub
		movieRepository.save(movieId);
		
	}

	@Override
	public String deleteById(int movieId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> tempMovie=movieRepository.findById(movieId);

		
		
		// throw exception if null
		
		if (!tempMovie.isPresent()) {
			throw new MovieNotFoundException("Movie id not found - " + movieId);
		}
		
		movieRepository.deleteById(movieId);
		
		return "Deleted movie id - " + movieId;
		
		
		
		
	}

	/*@Override
	public List<Movie> findAllByOrderByRatingAsc(double rating) {
		// TODO Auto-generated method stub
		return movieRepository.findAllByOrderByRatingAsc(rating);
	}*/

    
}
	
	
	










