package com.annoing.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.service.WordService;

@RestController
@RequestMapping("words")
public class WordController {
	private final WordService wordService;

	@Autowired
	public WordController(WordService wordService) {
		this.wordService = wordService;
	}

	@GetMapping
	public List<Word> list() {
		return wordService.getAll();
	}

	@GetMapping("{id}")
	public Word getOne(@PathVariable Word word) {
		return word;
	}

	@PostMapping("create")
	public Word create(@RequestBody Word word) {
		return wordService.save(word);
	}

	@PostMapping("edit")
	public Word edit(@RequestBody Word word) {
		return wordService.save(word);
	}

}
