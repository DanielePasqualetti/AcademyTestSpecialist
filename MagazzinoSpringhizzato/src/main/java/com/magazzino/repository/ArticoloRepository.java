package com.magazzino.repository;

import org.springframework.data.repository.CrudRepository;

import com.magazzino.model.Articolo;

public interface ArticoloRepository extends CrudRepository<Articolo, Integer> {

}
