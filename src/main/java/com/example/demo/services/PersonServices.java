package com.example.demo.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;



@Service
public class PersonServices {
	
	private AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastName("costa");
		person.setAddress("Umberlandia - Minas Gerais - Brasil");
		person.setGener("Male");
		
		return person;	
	}

}
