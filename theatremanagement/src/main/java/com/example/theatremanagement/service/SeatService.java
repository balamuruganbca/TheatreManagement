package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.theatremanagement.entity.Seat;
import com.example.theatremanagement.exception.SeatNotFoundException;

public interface SeatService {
	
	public List<Seat> findAll();
	
	public Seat findById(int seatId) throws SeatNotFoundException;

	public void save(Seat theSeat);

	public String deleteById(int seatId) throws SeatNotFoundException;
	
	public Seat findAllByScreenId(int screenId);

	

}