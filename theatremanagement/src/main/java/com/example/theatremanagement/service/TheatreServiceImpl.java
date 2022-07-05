package com.example.theatremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatremanagement.dao.TheatreRepository;
import com.example.theatremanagement.entity.Screen;
import com.example.theatremanagement.entity.Theatre;
import com.example.theatremanagement.exception.ScreenNotFoundException;
import com.example.theatremanagement.exception.TheatreNotFoundException;

@Service //service annotation is used to perform service related tasks and present in service layer.

public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;

    @Autowired //used for dependency injection.
    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

	@Override
	public List<Theatre> findAll() {
		// TODO Auto-generated method stub
		return theatreRepository.findAll();
	}

	@Override
	public Theatre findById(int theatreId) throws TheatreNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Theatre> result=theatreRepository.findById(theatreId);

		
		Theatre theTheatre=null;
		
		if(result.isPresent())
		{
			theTheatre=result.get();
		}
		else
		{
			throw new TheatreNotFoundException("Did not found theatre id-"+theatreId);
		}
		return theTheatre;
	}

	@Override
	public void save(Theatre theTheatre) {
		// TODO Auto-generated method stub
		theatreRepository.save(theTheatre);
		
		
		
	}

	@Override
	public String deleteById(int theatreId) throws TheatreNotFoundException {
		// TODO Auto-generated method stub
		Optional<Theatre> theTheatre = theatreRepository.findById(theatreId);
		
		// throw exception if null
		
		if (!theTheatre.isPresent()) {
			throw new TheatreNotFoundException("Theatre id not found - " + theatreId);
		}
		
		theatreRepository.deleteById(theatreId);
		
		return "Deleted theatre id - " + theatreId;
		
	}

    
    
    
    
    
}