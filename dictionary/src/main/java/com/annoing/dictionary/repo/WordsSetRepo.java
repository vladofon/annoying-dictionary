package com.annoing.dictionary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.annoing.dictionary.domain.WordsSet;

@Repository
public interface WordsSetRepo extends JpaRepository<WordsSet, Long> {

}
