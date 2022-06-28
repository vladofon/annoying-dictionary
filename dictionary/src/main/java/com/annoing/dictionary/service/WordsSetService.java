package com.annoing.dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.repo.WordsSetRepo;

@Service
public class WordsSetService {
	private final WordsSetRepo wordsSetRepo;

	@Autowired
	public WordsSetService(WordsSetRepo wordsSetRepo) {
		this.wordsSetRepo = wordsSetRepo;
	}

	public List<WordsSet> getAll() {
		return wordsSetRepo.findAll();
	}

	public WordsSet save(WordsSet wordsSet) {
		return wordsSetRepo.save(wordsSet);
	}

	public void remove(Long id) {
		wordsSetRepo.deleteById(id);
	}
}
