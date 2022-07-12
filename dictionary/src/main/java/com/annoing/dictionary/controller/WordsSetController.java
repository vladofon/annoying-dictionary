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
import org.springframework.web.bind.annotation.RestController;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordsSetDto;
import com.annoing.dictionary.domain.view.WordsSetView;
import com.annoing.dictionary.service.UserService;
import com.annoing.dictionary.service.WordService;
import com.annoing.dictionary.service.WordsSetService;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
@RequestMapping("sets")
public class WordsSetController {

	private final WordsSetService wordsSetService;
	private final WordService wordService;
	private final UserService userService;

	@Autowired
	WordsSetController(WordsSetService wordsSetService, UserService userService, WordService wordService) {
		this.wordsSetService = wordsSetService;
		this.userService = userService;
		this.wordService = wordService;
	}

	@GetMapping
	@JsonView(WordsSetView.QuickView.class)
	public List<WordsSet> list() {
		return wordsSetService.getAll();
	}

	@GetMapping("{id}")
	public WordsSetDto getOne(@PathVariable Long id) {
		return wordsSetService.getFullOne(id);
	}

	@PostMapping
	@JsonView(WordsSetView.QuickView.class)
	public WordsSet create(@RequestBody WordsSet wordsSet, @AuthenticationPrincipal User author) {
		return wordsSetService.create(wordsSet, author);
	}

	@PutMapping("{id}")
	@JsonView(WordsSetView.QuickView.class)
	public WordsSet update(@RequestBody WordsSet afterUpdate, @PathVariable Long id) {
		return wordsSetService.update(afterUpdate, id);
	}

	@PutMapping("{id}/default")
	@JsonView(WordsSetView.QuickView.class)
	public WordsSet setDefault(@PathVariable Long id) {
		return wordsSetService.markAsDefault(wordsSetService.getOne(id));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		wordsSetService.remove(id);
	}

	@GetMapping("user/{id}")
	@JsonView(WordsSetView.QuickView.class)
	public List<WordsSet> userSets(@PathVariable String id) {
		return wordsSetService.getUserSets(id);
	}

	@GetMapping("find/{title}")
	@JsonView(WordsSetView.QuickView.class)
	public List<WordsSet> setsByTitle(@PathVariable String title) {
		return wordsSetService.getSetsByTitle(title);
	}
}
