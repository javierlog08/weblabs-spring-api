package com.weblabs.api.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weblabs.api.models.BookModel;
import com.weblabs.api.repositories.FooRepository;
import com.weblabs.api.services.BookService;

import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	FooRepository foo_repo;
	
	@MockBean
	private BookService bookService;

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
	
	@Test
	public void testBooks() throws Exception {
		
		ArrayList<BookModel> books = new ArrayList<BookModel>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		BookModel book = new BookModel();
		book.author = "RogelioSinan";
		book.name = "La boina Roja";
		book.publish_date = formatter.parse("1988-05-10");
		book.bookId = (long) 1;
		
		books.add(book);
		
		given(this.bookService.list()).willReturn(books);
		
		ObjectMapper json = new ObjectMapper();
		json.setDateFormat(formatter);
		
		this.mvc.perform(get("/books").with(user("admin").password("admin")))
		.andExpect(status().isOk())
		.andExpect(content().json(json.writeValueAsString(books)));
	}

}
