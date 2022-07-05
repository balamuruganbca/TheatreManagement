package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.exception.TheatreNotFoundException;

public interface TheatreService {
	
	public List<Theatre> findAll();
	
	public Theatre findById(int theatreId) throws TheatreNotFoundException;

	public void save(Theatre theTheatre);

	public String deleteById(int theatreId) throws TheatreNotFoundException;

}