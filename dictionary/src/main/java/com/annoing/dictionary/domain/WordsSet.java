package com.annoing.dictionary.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.annoing.dictionary.domain.view.WordsSetView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class WordsSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(WordsSetView.QuickView.class)
	private Long id;

	@Column(length = 100)
	@JsonView(WordsSetView.QuickView.class)
	private String title;

	@Column(length = 1000)
	@JsonView(WordsSetView.QuickView.class)
	private String description;

	@JsonView(WordsSetView.QuickView.class)
	private boolean defaultSet;

	@OneToMany(mappedBy = "wordsSet")
	@JsonView(WordsSetView.FullView.class)
	@JsonManagedReference
	private Set<Word> words;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonView(WordsSetView.FullView.class)
	@JsonBackReference
	private User author;

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

	public Set<Word> getWords() {
		return words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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
		WordsSet other = (WordsSet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
