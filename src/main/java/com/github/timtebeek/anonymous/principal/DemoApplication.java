package com.github.timtebeek.anonymous.principal;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@SuppressWarnings("static-method")
public class DemoApplication {
	public static void main(final String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public String get(final Principal user) {
		Assert.notNull(user);
		return user.getName();
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public String get() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Assert.notNull(auth);
		return auth.getName();
	}
}
