package com.annoing.dictionary.domain.dto;

import com.annoing.dictionary.domain.Word;

public class WordBodyDto {
	private Long id;

	private String value;

	private String context;

	public WordBodyDto() {
	}

	public WordBodyDto(Word word) {
		this.id = word.getId();
		this.value = word.getValue();
		this.context = word.getContext();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
