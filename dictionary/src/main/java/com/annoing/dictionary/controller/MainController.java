package com.annoing.dictionary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping
	public String mainPage() {
		return "Begin...";
	}

	@GetMapping("/another")
	public String anotherPage() {
		return "Another mapping...";
	}

}
