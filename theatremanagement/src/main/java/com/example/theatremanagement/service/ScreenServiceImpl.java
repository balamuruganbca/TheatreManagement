package com.example.theatremanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theatremanagement.dao.ScreenRepository;
import com.example.theatremanagement.entity.Screen;
import com.example.theatremanagement.exception.ScreenNotFoundException;

@Service  //Service annotation means that is perform service tasks present in service layer.
public class ScreenServiceImpl implements ScreenService{
	
	private ScreenRepository screenRepository;
	
	
	 @Autowired //used for dependency injection.
	    public ScreenServiceImpl(ScreenRepository screenRepository) {
	        this.screenRepository  = screenRepository;
	    }


	@Override
	public List<Screen> findAll() {
		// TODO Auto-generated method stub
		return screenRepository.findAll();
	}


	@Override
	public Screen findById(int screenId) throws ScreenNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Screen> result=screenRepository.findById(screenId);
		
		Screen theScreen=null;
		
		if(result.isPresent())
		{
			theScreen=result.get();
		}
		else
		{
			throw  new ScreenNotFoundException("Did not found Screen id-"+screenId);
		}
		return theScreen;

	}



	@Override
	public void save(Screen theScreen) {
		// TODO Auto-generated method stub
		screenRepository.save(theScreen);
		
	}


	@Override
	public String deleteById(int screenId) throws ScreenNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Screen> theScreen=screenRepository.findById(screenId);

		
		
		// throw exception if null
		
		if (!theScreen.isPresent()) {
			throw new ScreenNotFoundException("screen id not found - " + screenId);
		}
		
		screenRepository.deleteById(screenId);
		
		return "Deleted screen id - " + screenId;
		
		
	}
	
	
	
}