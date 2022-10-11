package com.annoing.dictionary.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.annoing.dictionary.domain.User;
import com.annoing.dictionary.repo.UserDetailsRepo;
import com.annoing.dictionary.service.WordsSetService;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${frontend.url}")
	private String frontendUrl;

	private WordsSetService wordsSetService;

	@Autowired
	void setWordsSetService(WordsSetService wordsSetService) {
		this.wordsSetService = wordsSetService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/js/**", "/error**", "/sessions/me")
				.permitAll().anyRequest().authenticated().and().logout().logoutSuccessUrl(frontendUrl).permitAll().and()
				.logout().deleteCookies("JSESSIONID").and().rememberMe().key("uniqueAndSecret").and().csrf().disable();
	}

	@Bean
	public PrincipalExtractor principalExtractor(UserDetailsRepo userDetailsRepo) {
		return map -> {
			String id = (String) map.get("sub");

			User user = userDetailsRepo.findById(id).orElseGet(() -> {
				User newUser = new User();

				newUser.setId(id);
				newUser.setName((String) map.get("name"));
				newUser.setEmail((String) map.get("email"));
				newUser.setLocale((String) map.get("locale"));
				newUser.setGender((String) map.get("gender"));
				newUser.setUserpic((String) map.get("picture"));

				return newUser;
			});

			user.setLastVisit(LocalDateTime.now());

			return userDetailsRepo.save(user);
		};
	}

	// To enable CORS
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();

		List<String> allowedMethods = new ArrayList<>();
		allowedMethods.add("GET");
		allowedMethods.add("POST");
		allowedMethods.add("PUT");
		allowedMethods.add("DELETE");
		allowedMethods.add("OPTIONS");

		List<String> allowedHeaders = new ArrayList<>();
		allowedMethods.add("Authorization");
		allowedMethods.add("Cache-Control");
		allowedMethods.add("Content-Type");

		List<String> allowedOriginsUrl = new ArrayList<>();
		allowedOriginsUrl.add("http://localhost:8081/");
		allowedOriginsUrl.add("http://192.192.168.2.104:8081/");
		allowedOriginsUrl.add(frontendUrl);
		configuration.setAllowedOrigins(allowedOriginsUrl);
		configuration.setAllowedMethods(allowedMethods);
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(allowedHeaders);
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
}
