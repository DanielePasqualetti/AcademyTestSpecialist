package com.magazzino.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.magazzino.model.Articolo;
import com.magazzino.service.ArticoloService;

@RestController
@RequestMapping(path = "/articolo")
public class ArticoloController {

	@Autowired
	ArticoloService articoloSvc;

	@GetMapping(path = "/all")
	public Iterable<Articolo> getAll() {
		return articoloSvc.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Articolo> getById(@PathVariable int id) {
		return articoloSvc.findById(id);
	}

	@PostMapping(path = "/add")
	public String aggiungiArticolo(@RequestBody Articolo articolo) {
		return articoloSvc.aggiungi(articolo);
	}
	
	@PutMapping(path = "/update/{id}")
	public @ResponseBody String modificaArticolo(
			@PathVariable int id,
			@RequestParam String nome,
			@RequestParam int dataDiScadenza,
			@RequestParam double prezzo,
			@RequestParam int qualita,
			@RequestParam String categoria) {
		Optional<Articolo> optional = articoloSvc.findById(id);
		if (optional.isPresent()) {
			Articolo art = optional.get();
			art.setNome(nome);
			art.setDataDiScadenza(dataDiScadenza);
			art.setPrezzo(prezzo);
			art.setQualita(qualita);
			art.setCategoria(categoria);
			articoloSvc.update(art);
			return "Articolo salvato";
		} else {
			return "Articolo non esistnete";
		}
	}
	
	@DeleteMapping(path = "/delete{id}")
	public @ResponseBody String deleteArticolo(@RequestParam Integer id) {
		Optional<Articolo> optional = articoloSvc.findById(id);
		if(optional.isPresent()) {
			articoloSvc.delete(optional);
			return "Articolo eliminato";
		} else {
			return "Articolo non trovato";
		}
	}
}
