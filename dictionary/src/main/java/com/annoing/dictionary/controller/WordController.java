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

import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordEntryDto;
import com.annoing.dictionary.domain.view.WordView;
import com.annoing.dictionary.service.WordService;
import com.annoing.dictionary.service.WordsSetService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
@RequestMapping("words")
public class WordController {

	private final WordService wordService;
	private final WordsSetService wordsSetService;

	@Autowired
	public WordController(WordService wordService, WordsSetService wordsSetService) {
		this.wordService = wordService;
		this.wordsSetService = wordsSetService;
	}

	@GetMapping
	@JsonView(WordView.QuickView.class)
	public List<Word> list() {
		return wordService.getAll();
	}

	@GetMapping("{id}")
	@JsonView(WordView.QuickView.class)
	public Word getOne(@PathVariable Long id) {
		return wordService.get(id);
	}

	@PostMapping
	@JsonView(WordView.QuickView.class)
	public Word create(@RequestBody WordEntryDto word) {
		WordsSet owner;

		if (word.getSetId() != null && word.getSetId() != -1) {
			owner = wordsSetService.getOne(word.getSetId());
		} else {
			owner = wordsSetService.getDefaultSet();
		}

		Word created = new Word();

		created.setValue(word.getValue());
		created.setContext(word.getContext());
		created.setSet(owner);

		return wordService.save(created);
	}

	@PutMapping("{id}")
	@JsonView(WordView.QuickView.class)
	public Word edit(@RequestBody Word word, @PathVariable Long id) {
		Word beforeUpdate = wordService.get(id);

		beforeUpdate.setValue(word.getValue());
		beforeUpdate.setContext(word.getContext());

		return wordService.save(beforeUpdate);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		wordService.remove(id);
	}

}
