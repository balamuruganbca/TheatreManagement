package com.example.theatremanagement.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.theatremanagement.entity.Movie;
import com.example.theatremanagement.entity.Seat;
import com.example.theatremanagement.exception.SeatNotFoundException;
import com.example.theatremanagement.service.SeatService;
import com.example.theatremanagement.service.UserService;

@RestController  //The RestController allows to handle all REST APIs.
@RequestMapping("/apb")  //used to map web requests onto specific handler classes/methods.


public class SeatController {
	
	
	private SeatService seatService;
	
	@Autowired
	public SeatController(SeatService seatService) {
		super();
		this.seatService = seatService;
	}



	@GetMapping("/seats")  //maps HTTP GET requests onto specific handler methods.
	public List<Seat> getAllSeats()
	{
		List<Seat> theSeats=seatService.findAll();
		
		return theSeats;
		
	}
	
	
	
	@GetMapping("/seats/{seatId}")
	public Seat getSeatById(@PathVariable int seatId) throws SeatNotFoundException
	{
		Seat seat=seatService.findById(seatId);
		return seat;
		
	}
	
	
	@PostMapping("/seats")  //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Seat addSeat(@RequestBody Seat theSeat)
	{
		theSeat.setSeatId(0);
		
		seatService.save(theSeat);
		
		return theSeat;
		
	}
	
	@PutMapping("/seats")   //acts as a shortcut for @RequestMapping(method = RequestMethod. POST).
	public Seat updateMovies(@RequestBody Seat theSeat)
	{
		
		seatService.save(theSeat);
		
		return theSeat;
		
	}

	@DeleteMapping("/seats/{seatId}")  //HTTP DELETE requests onto specific handler methods
	public String deleteSeatById(@PathVariable int seatId) throws SeatNotFoundException
	{
		String deletedSeat=seatService.deleteById(seatId);
		
		return deletedSeat;
		
	}
	
	@GetMapping("/seats/screenId")
	public Seat findAllByScreenId(@PathVariable int screenId)
	{
		Seat seat=seatService.findAllByScreenId(screenId);
		return seat;
		
	}
}