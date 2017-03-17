package com.github.timtebeek.anonymous.principal;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@SuppressWarnings("static-method")
public class DemoApplication {
	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/principal")
	public String get(final Principal user) {
		Assert.notNull(user, "Principal should not be null");
		return user.getName();
	}

	@GetMapping("/authentication")
	public String get(final Authentication user) {
		Assert.notNull(user, "Authentication should not be null");
		return user.getName();
	}

	@GetMapping("/anonymous")
	public String get(final AnonymousAuthenticationToken user) {
		Assert.notNull(user, "AnonymousAuthenticationToken should not be null");
		return user.getName();
	}

	@GetMapping("/authprincipal")
	public String get(@AuthenticationPrincipal final UserDetails userdetails) {
		Assert.notNull(userdetails, "UserDetails should not be null");
		return userdetails.getUsername();
	}

	@GetMapping("/context")
	public String get() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Assert.notNull(auth, "SecurityContext Authentication should not be null");
		return auth.getName();
	}
}
