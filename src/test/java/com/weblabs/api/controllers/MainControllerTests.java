package com.weblabs.api.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.weblabs.api.repositories.FooRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	FooRepository foo_repo;

	@Test
	public void testingHome() throws Exception {
		this.mvc.perform(get("/")).andDo(print()).andExpect(content().string(containsString("Welcome to API Base project.")));
	}
	
	@Test
	public void testFoo() throws Exception {
		this.mvc.perform(get("/foo").with(user("admin").password("admin")))
		.andExpect(status().isOk())
		.andExpect(jsonPath("[*]").hasJsonPath());
	}

}
