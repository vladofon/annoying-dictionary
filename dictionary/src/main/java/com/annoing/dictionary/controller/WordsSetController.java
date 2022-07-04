package com.annoing.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.service.WordsSetService;

@CrossOrigin
@RestController
@RequestMapping("sets")
public class WordsSetController {

	private WordsSetService wordsSetService;

	@Autowired
	WordsSetController(WordsSetService wordsSetService) {
		this.wordsSetService = wordsSetService;
	}

	@GetMapping
	public List<WordsSet> list() {
		return wordsSetService.getAll();
	}

	@GetMapping("{id}")
	public WordsSet getOne(@PathVariable Long id) {
		return wordsSetService.getOne(id);
	}

	@PostMapping
	public WordsSet create(@RequestBody WordsSet wordsSet) {
		return wordsSetService.save(wordsSet);
	}

	@PutMapping("{id}")
	public WordsSet update(@RequestBody WordsSet wordsSet) {
		return wordsSetService.save(wordsSet);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		wordsSetService.remove(id);
	}
}
