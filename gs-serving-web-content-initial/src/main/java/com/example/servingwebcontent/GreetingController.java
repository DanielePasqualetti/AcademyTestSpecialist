package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "Daniele") String name,
			@RequestParam(name = "lastname", required = false, defaultValue = "Pasqualetti") String lastname, 
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("lastname", lastname);
		return "greeting";
	}

}