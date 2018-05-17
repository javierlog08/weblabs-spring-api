package com.weblabs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblabs.api.models.FooModel;
import com.weblabs.api.repositories.FooRepository;

@RestController
public class MainController {
	
	@Autowired
	private FooRepository fooRepository;

	@RequestMapping("/")
	String home() {
		return "Hello World Nigga!";
	}
	
	@RequestMapping("/test")
	String test() {
		Iterable<FooModel> i = fooRepository.findAll();
		
		String names = "";
		for(FooModel model : i ) {
			names += model.name + " ";
		}
		
		return "All found names of Foo are: "+names;
		
	}
	
	@RequestMapping("/loginx")
	String login() {
		return "Need to be logged in";
	}
}
