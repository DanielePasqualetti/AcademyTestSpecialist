package com.example.accessingdatamysql;

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

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@PutMapping(path = "/update")
	public @ResponseBody String updateUser(@RequestParam Integer id, @RequestParam String name,
			@RequestParam String email) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			User u = userOptional.get();
			u.setName(name);
			u.setEmail(email);
			userRepository.save(u);
			return "Utente aggiornato";
		} else {
			return "Utente non trovato";
		}
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteUser(@RequestParam Integer id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			userRepository.deleteById(id);
			return "Utente eliminato";
		} else {
			return "Utente non trovato!!!";
		}
	}

	@GetMapping(path = "searchByName")
	public @ResponseBody Iterable<User> searchUserByName(@RequestParam String name) {
		return userRepository.findByName(name);
	}

	@GetMapping(path = "searchByEmail")
	public @ResponseBody Iterable<User> searchUserByEmail(@RequestParam String email) {
		return userRepository.findByEmail(email);
	}
	
	@GetMapping(path = "/searchByNameAndEmail")
	public @ResponseBody Iterable<User> searchUserByNameAndEmail(@RequestParam String name, @RequestParam String email) {
	    return userRepository.findByNameAndEmail(name, email);
	}

//	@GetMapping(path = "details/{id}")
//	public @ResponseBody String detailUser(@PathVariable Integer id) {
//		Optional<User> userOptional = userRepository.findById(id);
//		if (userOptional.isPresent()) {
//			userRepository.deleteById(id);
//			return "Utente eliminato";
//		} else {
//			return "Utente non trovato!!!";
//		}
//	}
	
}
