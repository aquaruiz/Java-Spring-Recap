package com.mysite.mvcconference.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	@GetMapping("greeting")
	public String greeting(Map<String, Object> model) {
		model.put("message", "Hello Bryan");
		return "greeting"; // returns jsp file name
		
	}
	
	@GetMapping("thyme")
	public String thyme(Map<String, Object> model) {
		model.put("message", "Hello THYMELEAF");
		return "thyme"; // returns jsp file name
		
	}
	
	@DeleteMapping
	public void name() {
		
	}
}
