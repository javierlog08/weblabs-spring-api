package com.weblabs.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.weblabs.api.models.FooModel;

public interface FooRepository extends CrudRepository<FooModel, Long> {}
