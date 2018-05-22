package com.weblabs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weblabs.api.models.BookModel;
import com.weblabs.api.repositories.BooksRepository;

@Service
public class BookService {

	@Autowired
	BooksRepository booksRepository;

	public Iterable<BookModel> list() {
		return booksRepository.findAll();
	}
}
