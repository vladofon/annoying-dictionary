package com.annoing.dictionary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annoing.dictionary.domain.Word;

public interface WordRepo extends JpaRepository<Word, Long> {

}
