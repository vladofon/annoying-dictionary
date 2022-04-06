package com.annoing.dictionary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annoing.dictionary.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
