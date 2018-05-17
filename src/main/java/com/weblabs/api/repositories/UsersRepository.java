package com.weblabs.api.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.weblabs.api.models.UserModel;

public interface UsersRepository extends CrudRepository<UserModel, Long> {
	
	/**
	 * Based in LookUp Stragety in spring JPA
	 * @param username
	 * @Autor javierlog08
	 * @return
	 */
	Optional<UserModel> findByUsername(String username);
}
