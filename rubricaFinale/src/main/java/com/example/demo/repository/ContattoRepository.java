package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Contatto;

public interface ContattoRepository extends CrudRepository <Contatto, Integer>{

	Iterable<Contatto> findByName(String name);

	Iterable<Contatto> findByLastname(String lastname);

	Iterable<Contatto> findByNumber(String number);

	Iterable<Contatto> findByEmail(String email);

	
}
