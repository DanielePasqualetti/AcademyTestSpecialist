package com.example.accessingdatamysql;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

	Iterable<User> findByName(String name);

	Iterable<User> findByEmail(String email);
	
	Iterable<User> findByNameAndEmail(String name, String email);

}