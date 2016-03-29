package com.github.timtebeek.anonymous.principal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest(randomPort = true)
public class DemoApplicationIT {
	@Value("http://localhost:${local.server.port}")
	private String			host;

	private RestTemplate	rest	= new TestRestTemplate();

	@Test
	public void principal() {
		ResponseEntity<String> entity = rest.getForEntity(host + "/principal", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void authprincipal() {
		ResponseEntity<String> entity = rest.getForEntity(host + "/authprincipal", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}

	@Test
	public void authentication() {
		ResponseEntity<String> entity = rest.getForEntity(host + "/authentication", String.class);
		Assert.assertTrue(entity.toString(), entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("guest", entity.getBody());
	}
}
