package com.annoing.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.domain.dto.WordBodyDto;
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
	public Word create(@RequestBody WordEntryDto word, @AuthenticationPrincipal User author) {
		return wordService.create(word, author);
	}

	@PutMapping("{id}")
	@JsonView(WordView.QuickView.class)
	public Word edit(@RequestBody Word word, @PathVariable Long id, @AuthenticationPrincipal User author) {
		return wordService.update(word, id, author);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id, @AuthenticationPrincipal User author) {
		wordService.remove(id, author);
	}

	@GetMapping("find/{value}")
	public List<WordBodyDto> wordsByValue(@PathVariable String value, @RequestParam(defaultValue = "0") Long limit) {
		return wordService.getWordsByValue(value, limit);
	}

}
