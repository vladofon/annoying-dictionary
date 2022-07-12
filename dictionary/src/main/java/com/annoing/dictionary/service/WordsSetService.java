package com.annoing.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordsSetDto;
import com.annoing.dictionary.repo.UserDetailsRepo;
import com.annoing.dictionary.repo.WordsSetRepo;

@Service
public class WordsSetService {
	private final WordService wordService;
	private final UserService userService;
	private final WordsSetRepo wordsSetRepo;
	private final UserDetailsRepo userRepo;

	@Autowired
	public WordsSetService(WordService wordService, UserService userService, WordsSetRepo wordsSetRepo,
			UserDetailsRepo userRepo) {
		this.wordService = wordService;
		this.wordsSetRepo = wordsSetRepo;
		this.userService = userService;
		this.userRepo = userRepo;
	}

	public List<WordsSet> getAll() {
		return wordsSetRepo.findAll();
	}

	public WordsSet getOne(Long id) {
		return wordsSetRepo.findById(id).get();
	}

	public WordsSetDto getFullOne(Long id) {

		WordsSet set = getOne(id);
		WordsSetDto dto = new WordsSetDto();

		dto.setAuthorName(set.getAuthor().getName());
		dto.setDefaultSet(set.isDefaultSet());
		dto.setDescription(set.getDescription());
		dto.setId(set.getId());
		dto.setTitle(set.getTitle());
		dto.setWords(wordService.getSetWords(set));

		return dto;
	}

	public WordsSet save(WordsSet wordsSet) {
		return wordsSetRepo.save(wordsSet);
	}

	public WordsSet create(WordsSet wordsSet, User author) {
		wordsSet.setAuthor(author);
		wordsSet.setDefaultSet(false);

		return wordsSetRepo.save(wordsSet);
	}

	public WordsSet update(WordsSet afterUpdate, Long id) {
		WordsSet beforeUpdate = getOne(id);

		beforeUpdate.setDescription(afterUpdate.getDescription());
		beforeUpdate.setTitle(afterUpdate.getTitle());

		return wordsSetRepo.save(beforeUpdate);
	}

	public void remove(Long id) {
		if (!getOne(id).isDefaultSet())
			wordsSetRepo.deleteById(id);
	}

	public WordsSet createDefaultSet(User user) {
		WordsSet defaultSet = new WordsSet();
		defaultSet.setTitle("Default set");
		defaultSet.setDescription("You can save your words here");
		defaultSet.setAuthor(user);

		user.getSets().add(markAsDefault(defaultSet));

		userRepo.save(user);

		return defaultSet;
	}

	public WordsSet getDefaultSet(User author) {
		return wordsSetRepo.findByAuthorAndDefaultSetTrue(author).get(0);
	}

	public WordsSet markAsDefault(WordsSet set) {
		dropDefaultSet(set.getAuthor());

		set.setDefaultSet(true);

		return wordsSetRepo.save(set);
	}

	public List<WordsSet> getUserSets(String id) {
		User user = userService.getUser(id);
		List<WordsSet> sets = wordsSetRepo.findByAuthor(user);

		if (sets.isEmpty()) {
			sets.add(createDefaultSet(user));
		}

		return sets;
	}

	private void dropDefaultSet(User author) {
		List<WordsSet> defaultSet = wordsSetRepo.findByAuthorAndDefaultSetTrue(author);

		defaultSet.forEach(set -> set.setDefaultSet(false));

		wordsSetRepo.saveAll(defaultSet);
	}

	public List<WordsSet> getSetsByTitle(String title) {
		return wordsSetRepo.findByTitle(title);
	}

}
