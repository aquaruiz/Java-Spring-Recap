package com.spring.repository;

import java.util.List;

import com.spring.model.Speaker;

public interface SpeakerRepository {

	List<Speaker> findAll();

}