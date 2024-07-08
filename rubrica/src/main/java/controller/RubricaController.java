package controller;

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
import entity.Contatto;
import repository.ContattoRepository;

@Controller
@RequestMapping(path = "/demo")
public class RubricaController {

	@Autowired
	private ContattoRepository contattoRepository;

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
		contattoRepository.save(c);
		return "Contatto Salvato.";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Contatto> getAllContatti() {
		return contattoRepository.findAll();
	}
	
	@PutMapping(path = "/update")
	public @ResponseBody String updateContatto(
			@RequestParam Integer id, 
			@RequestParam String name,
			@RequestParam String lastname,
			@RequestParam String number, 
			@RequestParam String email) {
		Optional<Contatto> contattoOptional = contattoRepository.findById(id);
		if(contattoOptional.isPresent()) {
			Contatto c = contattoOptional.get();
			c.setName(name);
			c.setLastname(lastname);
			c.setNumber(number);
			c.setEmail(email);
			contattoRepository.save(c);
			return "Contatto Aggiornato.";
		} else {
			return "Contatto non trovato.";
		}
	}
	
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteContatto(@RequestParam Integer id) {
		Optional<Contatto> contattoOptional = contattoRepository.findById(id);
		if(contattoOptional.isPresent()) {
			contattoRepository.deleteById(id);
			return "Contatto Eliminato.";
		} else {
			return "Contatto non trovato.";
		}
	}
	
	@GetMapping(path = "/searchByName")
	public @ResponseBody Iterable<Contatto> searchContattoByName(@RequestParam String name) {
		return contattoRepository.findByName(name);
	}
	
	@GetMapping(path = "/searchByLastname")
	public @ResponseBody Iterable<Contatto> searchContattoByLastname(@RequestParam String lastname) {
		return contattoRepository.findByLastname(lastname);
	}
	
	@GetMapping(path = "/searchByNumber")
	public @ResponseBody Iterable<Contatto> searchContattoByNumber(@RequestParam String number) {
		return contattoRepository.findByNumber(number);
	}
	
	@GetMapping(path = "/searchByEmail")
	public @ResponseBody Iterable<Contatto> searchContattoByEmail(@RequestParam String email) {
		return contattoRepository.findByEmail(email);
	}
	
	
}
