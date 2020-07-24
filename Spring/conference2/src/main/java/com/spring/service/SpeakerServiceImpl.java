package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Speaker;
import com.spring.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService {
	
	private SpeakerRepository repository;
	
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
		this.repository = speakerRepository;
	}
	
	public SpeakerServiceImpl() {
		System.out.println("calling no args constructor");
	}

	@Override
	public List<Speaker> findAll () {
		return repository.findAll();
	}
	
	@Autowired
	public void setRepository(SpeakerRepository repository) {
		this.repository = repository;
		System.out.println("inside setter");
	}
}
