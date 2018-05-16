package com.weblabs.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="foo")
public class FooModel {

	@Id public Long id;
	public String name;
}
