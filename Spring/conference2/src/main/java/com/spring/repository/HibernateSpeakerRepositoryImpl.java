package com.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.Speaker;

@Repository
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
	@Override
	public List<Speaker> findAll() {
		List<Speaker> speakers = new ArrayList<>();
		
		Speaker speaker = new Speaker();
		speaker.setFirstName("Anna");
		speaker.setLastName("Ivanova");
		
		speakers.add(speaker);
		return speakers;
	}
}
