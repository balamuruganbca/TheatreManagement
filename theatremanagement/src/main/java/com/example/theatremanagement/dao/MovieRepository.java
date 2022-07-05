package com.example.theatremanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theatremanagement.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

	//List<Movie> findAllByOrderByRatingAsc(double rating); 

}
