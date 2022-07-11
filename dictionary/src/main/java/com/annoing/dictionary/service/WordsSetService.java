package com.annoing.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.repo.UserDetailsRepo;
import com.annoing.dictionary.repo.WordsSetRepo;

@Service
public class WordsSetService {
	private final WordsSetRepo wordsSetRepo;
	private final UserDetailsRepo userRepo;

	@Autowired
	public WordsSetService(WordsSetRepo wordsSetRepo, UserDetailsRepo userRepo) {
		this.wordsSetRepo = wordsSetRepo;
		this.userRepo = userRepo;
	}

	public List<WordsSet> getAll() {
		return wordsSetRepo.findAll();
	}

	public WordsSet getOne(Long id) {
		return wordsSetRepo.findById(id).get();
	}

	public WordsSet save(WordsSet wordsSet) {
		return wordsSetRepo.save(wordsSet);
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

	public List<WordsSet> userSets(User author) {
		return wordsSetRepo.findByAuthor(author);
	}

	private void dropDefaultSet(User author) {
		List<WordsSet> defaultSet = wordsSetRepo.findByAuthorAndDefaultSetTrue(author);

		defaultSet.forEach(set -> set.setDefaultSet(false));

		wordsSetRepo.saveAll(defaultSet);
	}

}
