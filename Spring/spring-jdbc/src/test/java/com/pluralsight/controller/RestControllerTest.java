package com.pluralsight.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.pluralsight.model.Ride;

public class RestControllerTest {

	@Test(timeout=6000)
	public void testGetRides() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
				"http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Ride>>() {
				});
		List<Ride> rides = ridesResponse.getBody();

		for (Ride ride : rides) {
			System.out.println("Ride name: " + ride.getName());
		}
	}
	
	@Test(timeout = 3000)
	public void testCreateRide() {
		RestTemplate restTemplate = new RestTemplate();
		
		Ride ride = new Ride();
		ride.setName("Sagebrish Tail");
		ride.setDuration(38);
		
		ride = restTemplate.postForObject("http://localhost:8080/ride_tracker/ride", ride, Ride.class);
		System.out.println("Ride: " + ride);
	}
	
	@Test(timeout = 5000)
	public void testGetRide() {
		RestTemplate restTemplate = new RestTemplate();
		Ride ride = restTemplate.getForObject("http://localhost:8080/ride_tracker/ride/2", Ride.class);
		System.out.println("Ride: " + ride.getName());
	}
	
	@Test(timeout = 5000)
	public void testUpdateRide() {
		RestTemplate restTemplate = new RestTemplate();
		Ride ride = restTemplate.getForObject("http://localhost:8080/ride_tracker/ride/2", Ride.class);
		ride.setDuration(ride.getDuration()+1000);

		restTemplate.put("http://localhost:8080/ride_tracker/ride", ride);
		System.out.println("Ride: " + ride.getName());
	}
	
	@Test(timeout = 3000)
	public void testDeleteRide() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/ride_tracker/ride/9/delete");
	}
	
	@Test(timeout = 3000)
	public void testException() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8080/ride_tracker/test", Ride.class);
	}
}