package com.magazzino.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magazzino.model.Articolo;
import com.magazzino.repository.ArticoloRepository;

@Service
public class ArticoloService {

	@Autowired
	ArticoloRepository articoloRepo;

	public Iterable<Articolo> findAll() {
		return articoloRepo.findAll();
	}

	public Optional<Articolo> findById(int id) {
		return articoloRepo.findById(id);
	}

	public String aggiungi(Articolo articolo) {
		if (articolo.equals(null)) {
			return "Articolo Vuoto.";
		} else {
			return "Articolo Salvato";
		}
	}

	public Articolo update(Articolo art) {
		return articoloRepo.save(art);		
	}


	public Articolo delete(Articolo art) {
		return articoloRepo.delete(art);
	}

	
}
