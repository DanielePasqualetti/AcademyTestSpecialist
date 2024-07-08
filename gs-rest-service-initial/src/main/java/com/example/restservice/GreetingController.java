package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "Daniele") String name,
			@RequestParam(value = "lastname", defaultValue = "Pasqualetti") String lastname) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name + " " + lastname));
	}
}