package com.annoing.dictionary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordBodyDto;
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

	public List<WordBodyDto> getSetWords(WordsSet set) {
		return wordRepo.findByWordsSet(set);
	}

	public Word get(Long id) {
		return wordRepo.findById(id).get();
	}

	public Word save(Word word) {
		return wordRepo.save(word);
	}

	public void remove(Long id) {
		wordRepo.deleteById(id);
	}

}
