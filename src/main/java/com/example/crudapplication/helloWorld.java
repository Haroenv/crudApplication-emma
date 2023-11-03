package com.example.crudapplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {

	@RequestMapping("/")
	String hello() {
		return "Hello world!";
	}

}
