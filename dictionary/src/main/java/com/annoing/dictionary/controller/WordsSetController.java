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

		WordsSet set = wordsSetService.getOne(id);
		WordsSetDto dto = new WordsSetDto();

		dto.setAuthorName(set.getAuthor().getName());
		dto.setDefaultSet(set.isDefaultSet());
		dto.setDescription(set.getDescription());
		dto.setId(set.getId());
		dto.setTitle(set.getTitle());
		dto.setWords(wordService.getSetWords(set));

		return dto;
	}

	@PostMapping
	public WordsSet create(@RequestBody WordsSet wordsSet, @AuthenticationPrincipal User author) {
		wordsSet.setAuthor(author);
		wordsSet.setDefaultSet(false);

		return wordsSetService.save(wordsSet);
	}

	@PutMapping("{id}")
	public WordsSet update(@RequestBody WordsSet afterUpdate, @PathVariable Long id) {
		WordsSet beforeUpdate = wordsSetService.getOne(id);

		beforeUpdate.setDescription(afterUpdate.getDescription());
		beforeUpdate.setTitle(afterUpdate.getTitle());

		return wordsSetService.save(beforeUpdate);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		wordsSetService.remove(id);
	}

	@GetMapping("user/{id}")
	@JsonView(WordsSetView.QuickView.class)
	public List<WordsSet> userSets(@PathVariable String id) {
		User user = userService.getUser(id);
		List<WordsSet> sets = wordsSetService.userSets(user);

		if (sets.isEmpty()) {
			sets.add(wordsSetService.createDefaultSet(user));
		}

		return sets;
	}
}
