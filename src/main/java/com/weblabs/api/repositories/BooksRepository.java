package com.weblabs.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.weblabs.api.models.BookModel;

public interface BooksRepository extends CrudRepository<BookModel, Long> {}
