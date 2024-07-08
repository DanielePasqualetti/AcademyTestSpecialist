package com.example.demo.controller;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bet;
import com.example.demo.enums.ETypeOfBet;
import com.example.demo.repository.BetRepository;

@RestController
@RequestMapping(path = "/app")
public class BetController {

	@Autowired
	BetRepository betRepo;
	
	@GetMapping(path = "/bets")
	public @ResponseBody Iterable<Bet> getAll(){
		return betRepo.findAll();
	}
	
	@GetMapping(path = "/bets/{id}")
	public @ResponseBody ResponseEntity<?> getBetById(@PathVariable Long id){
		Optional<Bet> optionalBet = betRepo.findById(id);
		if(optionalBet.isPresent()) {
			return ResponseEntity.ok(optionalBet.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bet non trovata.");
		}
	}
	
	@PostMapping(path = "/bets")
	public @ResponseBody String addNewBet(
			@RequestParam double amount,
			@RequestParam ETypeOfBet type) {
		Bet b = new Bet();
		b.setAmount(amount);
		b.setType(type);
		b.setTimestamp(Instant.now());
		betRepo.save(b);
		return "Bet salvata";
	}
	
	@PutMapping(path = "/bets/{id}")
	public @ResponseBody String updateBet(
			@RequestParam double amount,
			@RequestParam ETypeOfBet type,
			@RequestParam Instant timestamp,
			@PathVariable long id) {
		Optional<Bet> optionalBet = betRepo.findById(id);
		if(optionalBet.isPresent()) {
			Bet b = optionalBet.get();
			b.setAmount(amount);
			b.setType(type);
			b.setTimestamp(timestamp);
			betRepo.save(b);
			return "Bet modificata con successo";
		} else {
			return "Bet non trovata";
		}
	}
	
	@DeleteMapping(path = "/bets/{id}")
	public @ResponseBody String deleteBet(@RequestParam long id) {
		Optional<Bet> optionalBet = betRepo.findById(id);
		if(optionalBet.isPresent()) {
			betRepo.deleteById(id);
			return "Bet eliminata correttamente";
		} else {
			return "Bet non trovata";
		}
	}
	
	
}
