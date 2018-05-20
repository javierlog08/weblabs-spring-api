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
	String index() {
		return "Welcome to API Base project.";
	}
	
	@RequestMapping("/foo")
	Iterable<FooModel> foo() {
		Iterable<FooModel> i = fooRepository.findAll();
		
		return i;
		
	}
}
