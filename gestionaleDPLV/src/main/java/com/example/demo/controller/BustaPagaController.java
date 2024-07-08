package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.BustaPaga;
import com.example.demo.repository.BustaPagaRepository;

/**
 * In questa classe avviene l'intercettazione delle chiamate da url, che le traduce in operazioni CRUD
 * Tutto questo è possibile grazie alla repository bustaPagaRepo, che estende CrudRespository<?,?>
 *
 * @version 1.0
 * @author Daniele Pasqualetti, Lorenzo Vaccaro
 */

@Controller
@RequestMapping(path = "/bustaPaga")
public class BustaPagaController {
	
	//autowired per associare il bean alla repository
	@Autowired BustaPagaRepository bustaPagaRepo;
	
	/**
	 * getAll ci permette di raccogliere tutti i dati dei lavoratori, assieme al loro salario
	 * 
	 * @return Iterable di tipo BustaPaga
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<BustaPaga> getAll() {
		return bustaPagaRepo.findAll();
	}
	
	/**
	 * getBustaPagaById ci permette di raccogliere le informazioni riguardante una singola busta paga.
	 * Utilizza un id che verificherà se esiste quella busta paga o meno:
	 * Se esiste, allora ritorna la busta paga con quell'id,
	 * Se non esiste, allora ritorna una ResponseEntity not found con messaggio "Busta Paga non trovata"
	 *
	 * @param id Integer, corrisponde all'id presente nella tabella del database
	 * @return ResponseEntity, ok se la busta paga esiste, not found se non esiste
	 */
	@GetMapping (path = "/findById/{id}")
	public @ResponseBody ResponseEntity<?> getBustaPagaById(@PathVariable Integer id) {
		Optional<BustaPaga> optional =  bustaPagaRepo.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Busta Paga non trovata.");
		}	
	}
	
	/**
	 * findBustaPagaByName ci permette di raccogliere le eventuali buste paga.
	 * Utilizza il parametro name che verificherà se esistono busta paga associate a quel parametro name.
	 * Se esistono, ritornerà una lista che comprende tutte le buste paga con quel parametro name.
	 * Se non esistono, ritornerà una lista vuota.
	 * @param name String, corrisponde al paramentro name presente nella tabella del DB.
	 * @return Lista di BustaPaga se il parametro name da una corrispondenza nel DB altrimenti lista vuota.
	 */
	@GetMapping(path = "/findByName")
	public @ResponseBody Iterable<BustaPaga> findBustaPagaByName(@RequestParam String name) {
		return bustaPagaRepo.findByName(name);
	}
	
	/**
	 * findBustaPagaByLastname ci permette di raccogliere le eventuali buste paga.
	 * Utilizza il parametro lastname che verificherà se esistono busta paga associate a quel parametro lastname.
	 * Se esistono, ritornerà una lista che comprende tutte le buste paga con quel parametro lastname.
	 * Se non esistono, ritornerà una lista vuota.
	 * @param lastname String, corrisponde al paramentro lastname presente nella tabella del DB.
	 * @return Lista di BustaPaga se il parametro lastname da una corrispondenza nel database altrimenti lista vuota.
	 */
	@GetMapping(path = "/findByLastname")
	public @ResponseBody Iterable<BustaPaga> findBustaPagaByLastname(@RequestParam String lastname) {
		return bustaPagaRepo.findByLastname(lastname);
	}
	
	/**
	 * findBustaPagaByJob ci permette di raccogliere le eventuali buste paga.
	 * Utilizza il parametro job che verificherà se esistono busta paga associate a quel parametro job.
	 * Se esistono, ritornerà una lista che comprende tutte le buste paga con quel parametro job.
	 * Se non esistono, ritornerà una lista vuota.
	 * @param job String, corrisponde al paramentro job presente nella tabella del DB.
	 * @return Lista di BustaPaga se il parametro job da una corrispondenza nel DB altrimenti lista vuota.
	 */
	@GetMapping(path = "/findByJob")
	public @ResponseBody Iterable<BustaPaga> findBustaPagaByJob(@RequestParam String job) {
		return bustaPagaRepo.findByJob(job);
	}
	
	/**
	 * addNewBustaPagaConParametri ci permette di inserire una nuova busta paga.
	 * 
	 * @param name corrisponde al nome del lavoratore nella nostra busta paga
	 * @param lastname corrisponde al cognome del lavoratore nella nostra busta paga
	 * @param job corrisponde alla mansione del lavoratore nella nostra busta paga
	 * @param salary corrisponde al salario del lavoratore nella nostra busta paga
	 * @return string "Busta paga salvata."
	 */
	@PostMapping(path = "/addParam")
	public @ResponseBody String addNewBustaPagaConParametri(
			@RequestParam String name,
			@RequestParam String lastname,
			@RequestParam String job,
			@RequestParam double salary
			) {
		
		BustaPaga bp = new BustaPaga();
		bp.setName(name);
		bp.setLastname(lastname);
		bp.setJob(job);
		bp.setSalary(salary);
		bustaPagaRepo.save(bp);
		return "Busta paga salvata.";
	}
	
	/**
	 * addNewBustaPagaConBody ci permette di inserire nel DB una nuova busta paga utilizzando i dati passati nel corpo della richiesta HTTP.
	 *
	 * @param bustaPaga è l'oggetto BustaPaga fornito nel corpo della richiesta HTTP.
	 * @return una stringa che indica com'è andata l'operazione. Se la busta paga non è vuota e viene salvata con successo,
	 *         viene restituita la stringa "Busta paga salvata". Se la busta paga è vuota, viene restituita la stringa
	 *         "Busta paga vuota".
	 */
	@PostMapping(path = "/addBody")
	public @ResponseBody String addNewBustaPagaConBody(@RequestBody BustaPaga bustaPaga) {
	    if (bustaPaga != null) {
	        bustaPagaRepo.save(bustaPaga);
	        return "Busta paga salvata.";
	    } else {
	        return "Busta paga vuota.";
	    }
	}


	/**
	 * updateBustaPaga aggiorna una busta paga esistente identificata dall'id specificato, utilizzando i parametri forniti.
	 *
	 * @param name è il nuovo nome da assegnare alla busta paga.
	 * @param lastname è il nuovo cognome da assegnare alla busta paga.
	 * @param job è il nuovo lavoro da assegnare alla busta paga.
	 * @param salary è il nuovo salario da assegnare alla busta paga.
	 * @param id è l'id della busta paga da aggiornare.
	 * @return una stringa che indica lo stato dell'operazione. Se la busta paga con id specificato esiste nel database
	 *         e viene aggiornata correttamente, viene restituita la stringa "Busta Paga salvata". Se la busta paga con id
	 *         specificato non esiste nel database, viene restituita la stringa "Busta Paga non esistente.".
	 */
	@PutMapping(path = "/updateBustaPaga/{id}")
	public @ResponseBody String updateBustaPaga(
			@RequestParam String name,
			@RequestParam String lastname,
			@RequestParam String job,
			@RequestParam double salary,
			@PathVariable Integer id) {
				Optional<BustaPaga> optional = bustaPagaRepo.findById(id);
				if(optional.isPresent()) {
					BustaPaga bp = optional.get();
					bp.setName(name);
					bp.setLastname(lastname);
					bp.setJob(job);
					bp.setSalary(salary);
					bustaPagaRepo.save(bp);
					return "Busta paga salvata";
				} else {
					return "Busta paga non esistente.";
				}
	}
	
	/**
	 * updateSalarioById aggiorna il salario di una busta paga esistente identificata dall'id specificato.
	 *
	 * @param salary Il nuovo salario da assegnare alla busta paga.
	 * @param id indica l'id della busta paga da aggiornare.
	 * @return Una stringa che indica lo stato dell'operazione. Se la busta paga con l'id specificato esiste nel database
	 *         ed è aggiornata correttamente con il nuovo salario, viene restituita la stringa "Salario aggiornato". Se la
	 *         busta paga con l'id specificato non esiste nel database, viene restituita la stringa "Busta paga non esistente.".
	 */
	@PutMapping(path = "/updateSalary/{id}")
	public @ResponseBody String updateSalarioById(@RequestParam double salary, @PathVariable Integer id) {
		Optional<BustaPaga> optional = bustaPagaRepo.findById(id);
		if (optional.isPresent()) {
			BustaPaga bp = optional.get();
			bp.setSalary(salary);
			bustaPagaRepo.save(bp);
			return "Salario aggiornato";
		} else {
			return "Busta paga non esistente.";
		}
	}
	
	/**
	 * deleteBustaPaga elimina una busta paga esistente identificata dall'id specificato.
	 *
	 * @param id è il parametro della busta paga da eliminare.
	 * @return una stringa che indica lo stato dell'operazione. Se la busta paga con id specificato esiste nel database
	 *         ed è eliminata con successo, viene restituita la stringa "Busta paga eliminata.". Se la busta paga con id
	 *         specificato non esiste nel database, viene restituita la stringa "Busta paga non trovata.".
	 */
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteBustaPaga(@RequestParam Integer id) {
		Optional<BustaPaga> bustaPagaOptional = bustaPagaRepo.findById(id);
		if(bustaPagaOptional.isPresent()) {
			bustaPagaRepo.deleteById(id);
			return "Busta paga eliminata.";
		} else {
			return "Busta paga non trovata.";
		}
	}
}
		
		

