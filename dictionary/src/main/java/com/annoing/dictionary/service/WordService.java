package com.annoing.dictionary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordBodyDto;
import com.annoing.dictionary.domain.dto.WordEntryDto;
import com.annoing.dictionary.repo.WordRepo;

@Service
public class WordService {
	private final WordRepo wordRepo;
	private WordsSetService wordsSetService;

	@Autowired
	public WordService(WordRepo wordRepo) {
		this.wordRepo = wordRepo;

	}

	@Lazy
	@Autowired
	public void setWordsSetService(WordsSetService wordsSetService) {
		this.wordsSetService = wordsSetService;
	}

	public List<Word> getAll() {
		return wordRepo.findAll();
	}

	public List<WordBodyDto> getSetWords(WordsSet set) {
		return wordRepo.findByWordsSet(set);
	}

	public List<WordBodyDto> getWordsByValue(String value) {
		return wordRepo.findByValue(value);
	}

	public List<WordBodyDto> getWordsByValue(String value, Long limit) {
		if (limit > 0) {
			return wordRepo.findByValue(value, limit).stream().map(WordBodyDto::new).collect(Collectors.toList());
		}

		return getWordsByValue(value);
	}

	public Word get(Long id) {
		return wordRepo.findById(id).get();
	}

	public Word create(WordEntryDto word, User author) {
		WordsSet owner;

		if (word.getSetId() != null && word.getSetId() != -1) {
			owner = wordsSetService.getOne(word.getSetId());
		} else {
			owner = wordsSetService.getDefaultSet(author);
		}

		Word created = new Word();

		created.setValue(word.getValue());
		created.setContext(word.getContext());
		created.setSet(owner);

		return wordRepo.save(created);
	}

	public Word update(Word word, Long id, User author) {
		Word beforeUpdate = get(id);

		if (!beforeUpdate.getSet().getAuthor().equals(author)) {
			throw new IllegalArgumentException("You are not author of this word!");
		}

		beforeUpdate.setValue(word.getValue());
		beforeUpdate.setContext(word.getContext());

		return wordRepo.save(beforeUpdate);
	}

	public void remove(Long id, User author) {
		Word beforeUpdate = get(id);

		if (!beforeUpdate.getSet().getAuthor().equals(author)) {
			throw new IllegalArgumentException("You are not author of this word!");
		}

		wordRepo.deleteById(id);
	}

	public List<WordBodyDto> getUserWords(User author) {
		List<WordsSet> sets = wordsSetService.getUserSets(author.getId());

		List<WordBodyDto> words = new ArrayList<>();
		for (WordsSet set : sets) {
			words.addAll(wordRepo.findByWordsSet(set));
		}

		words.forEach(System.out::println);

		return words;
	}

}
