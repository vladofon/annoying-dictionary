package com.annoing.dictionary.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.WordsSet;

@Repository
public interface WordsSetRepo extends JpaRepository<WordsSet, Long> {

	@Query
	List<WordsSet> findByDefaultSetTrue();

	@Query
	List<WordsSet> findByAuthor(User author);
}
