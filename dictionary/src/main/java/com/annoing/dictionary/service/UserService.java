package com.annoing.dictionary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.repo.UserDetailsRepo;

@Service
public class UserService {

	private final UserDetailsRepo userRepo;

	@Autowired
	public UserService(UserDetailsRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User getUser(String id) {
		return userRepo.findById(id).get();
	}
}
