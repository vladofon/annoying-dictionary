package com.annoing.dictionary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.repo.WordRepo;

@Service
public class WordService {
	private final WordRepo wordRepo;

	public WordService(WordRepo wordRepo) {
		this.wordRepo = wordRepo;
	}

	public List<Word> getAll() {
		return wordRepo.findAll();
	}

	public Word save(Word word) {
		return wordRepo.save(word);
	}

	public void remove(Long id) {
		wordRepo.deleteById(id);
	}

}
