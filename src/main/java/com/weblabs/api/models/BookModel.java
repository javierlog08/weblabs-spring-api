package com.weblabs.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name="books")
public class BookModel {

	@Id
	@Column(name="book_id")
	public Long bookId;
	public String name;
	public String author;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	public Date publish_date;
	
}
