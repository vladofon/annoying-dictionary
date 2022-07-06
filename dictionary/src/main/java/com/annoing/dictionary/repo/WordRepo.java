package com.annoing.dictionary.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.annoing.dictionary.domain.Word;
import com.annoing.dictionary.domain.WordsSet;
import com.annoing.dictionary.domain.dto.WordBodyDto;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {
	List<WordBodyDto> findByWordsSet(WordsSet wordsSet);
}
