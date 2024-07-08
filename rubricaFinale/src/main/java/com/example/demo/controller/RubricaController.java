package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Contatto;
import com.example.demo.repository.ContattoRepository;

@Controller
@RequestMapping(path = "/demo")
public class RubricaController {

	@Autowired ContattoRepository contattoRepo;
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewContatto(
			@RequestParam String name,
			@RequestParam String lastname,
			@RequestParam String number,
			@RequestParam String email) {
		
		Contatto c = new Contatto();
		c.setName(name);
		c.setLastname(lastname);
		c.setNumber(number);
		c.setEmail(email);
		contattoRepo.save(c);
		return "Contatto Salvato.";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Contatto> getAll(){
		return contattoRepo.findAll();
	}
	
	@PutMapping(path = "/update")
	public @ResponseBody String updateContatto(
			@RequestParam Integer id,
			@RequestParam String name,
			@RequestParam String lastname,
			@RequestParam String number,
			@RequestParam String email) {
		Optional<Contatto> contattoOptional = contattoRepo.findById(id);
		if(contattoOptional.isPresent()) {
			Contatto c = contattoOptional.get();
			c.setName(name);
			c.setLastname(lastname);
			c.setNumber(number);
			c.setEmail(email);
			contattoRepo.save(c);
			return "Contatto Aggiornato.";
		} else {
			return "Contatto non trovato.";
		}
	}
	
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteContatto(@RequestParam Integer id) {
		Optional<Contatto> contattoOptional = contattoRepo.findById(id);
		if(contattoOptional.isPresent()) {
			contattoRepo.deleteById(id);
			return "Contatto Eliminato.";
		} else {
			return "Contatto non trovato.";
		}
	}
	
	@GetMapping(path = "/findByName")
	public @ResponseBody Iterable<Contatto> findContattoByName(@RequestParam String name) {
		return contattoRepo.findByName(name);
	}
	
	@GetMapping(path = "/findByLastname")
	public @ResponseBody Iterable<Contatto> findContattoByLastname(@RequestParam String lastname) {
		return contattoRepo.findByLastname(lastname);
	}
	
	@GetMapping(path = "/findByNumber")
	public @ResponseBody Iterable<Contatto> findContattoByNumber(@RequestParam String number) {
		return contattoRepo.findByNumber(number);
	}
	
	@GetMapping(path = "/findByEmail")
	public @ResponseBody Iterable<Contatto> findContattoByEmail(@RequestParam String email) {
		return contattoRepo.findByEmail(email);
	}
}
