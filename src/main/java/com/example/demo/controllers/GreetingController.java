package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/gretting")
	public Greeting greeting(
			@RequestParam(value="name", defaultValue = "Word")
			String name
			) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
