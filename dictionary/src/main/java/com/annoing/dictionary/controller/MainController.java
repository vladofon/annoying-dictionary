package com.annoing.dictionary.controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.domain.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("sessions/me")
	@JsonView(UserView.ProfileView.class)
	public ResponseEntity<?> user(@AuthenticationPrincipal User principal) {
		if (principal == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("error", "unauthorized"));
		}
		return ResponseEntity.ok(principal);
	}

	@GetMapping("sessions/Google/callback")
	public void googleCallback(HttpServletResponse response) throws IOException {
		response.sendRedirect("http://localhost:8081/profile");
	}
}
