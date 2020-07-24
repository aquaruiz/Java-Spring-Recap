package com.spring.service;

import java.util.List;

import com.spring.model.Speaker;
import com.spring.repository.HibernateSpeakerRepositoryImpl;
import com.spring.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();
	
	@Override
	public List<Speaker> findAll () {
		return repository.findAll();
	}
	
}
