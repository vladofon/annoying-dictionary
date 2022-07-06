package com.annoing.dictionary.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class WordsSetDto {

	private Long id;

	private String title;

	private String description;

	private boolean defaultSet;

	private List<WordBodyDto> words = new ArrayList<>();

	private String authorName;

	public WordsSetDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDefaultSet() {
		return defaultSet;
	}

	public void setDefaultSet(boolean defaultSet) {
		this.defaultSet = defaultSet;
	}

	public List<WordBodyDto> getWords() {
		return words;
	}

	public void setWords(List<WordBodyDto> words) {
		this.words = words;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
