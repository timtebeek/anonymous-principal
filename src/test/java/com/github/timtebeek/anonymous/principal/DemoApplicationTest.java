package com.github.timtebeek.anonymous.principal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTest {
	@Autowired
	private TestRestTemplate	rest;

	@Test
	public void principal() {
		ResponseEntity<String> entity = rest.getForEntity("/principal", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void authprincipal() {
		ResponseEntity<String> entity = rest.getForEntity("/authprincipal", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void authentication() {
		ResponseEntity<String> entity = rest.getForEntity("/authentication", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void anonymous() {
		ResponseEntity<String> entity = rest.getForEntity("/anonymous", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void context() {
		ResponseEntity<String> entity = rest.getForEntity("/context", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}
}
