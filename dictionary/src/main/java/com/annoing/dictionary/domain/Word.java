package com.annoing.dictionary.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.annoing.dictionary.domain.view.WordView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Word implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(WordView.QuickView.class)
	private Long id;

	@JsonView(WordView.QuickView.class)
	private String value;

	@Column(length = 1000)
	@JsonView(WordView.QuickView.class)
	private String context;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "words_set_id", nullable = false)
	@JsonBackReference
	@JsonView(WordView.FullView.class)
	private WordsSet wordsSet;

	public Word() {
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

	public WordsSet getSet() {
		return wordsSet;
	}

	public void setSet(WordsSet wordsSet) {
		this.wordsSet = wordsSet;
	}

	@Override
	public String toString() {
		return "Word [id=" + id + ", value=" + value + ", context=" + context + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
