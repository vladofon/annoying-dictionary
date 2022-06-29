package com.annoing.dictionary.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.annoing.dictionary.domain.Word;

@Repository
public interface WordRepo extends JpaRepository<Word, Long> {

}
