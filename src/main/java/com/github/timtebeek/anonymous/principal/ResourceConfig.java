package com.github.timtebeek.anonymous.principal;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/**").permitAll()
				.anyRequest().denyAll();

		// Anonymous user should authenticate as guest for authorization
		Collection<? extends GrantedAuthority> emptyList = Collections.emptyList();
		http.anonymous().principal(new User("guest", "guest", emptyList));
	}

	@Override
	public void configure(final ResourceServerSecurityConfigurer resources) {
		resources.resourceId("myresource");
	}
}
