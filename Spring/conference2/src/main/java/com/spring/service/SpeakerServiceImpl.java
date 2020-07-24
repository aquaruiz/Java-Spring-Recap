package com.spring.service;

import java.util.List;

import com.spring.model.Speaker;
import com.spring.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository;
	
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.repository = speakerRepository;
	}
	
	@Override
	public List<Speaker> findAll () {
		return repository.findAll();
	}
	
	public void setRepository(SpeakerRepository repository) {
		this.repository = repository;
	}
}
