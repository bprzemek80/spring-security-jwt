package com.borykapp.secure1.springsecurityjwt;

import com.borykapp.secure1.springsecurityjwt.security.AuthenticationService;
import com.borykapp.secure1.springsecurityjwt.security.model.AuthenticationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityJwtApplicationTests {

	@Autowired
	private AuthenticationService authenticationService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void validateJwtToken() {
		try {
			String authenticationToken = authenticationService.getAuthenticationToken(new AuthenticationRequest("foo", "foo"));
			assertNotNull(authenticationToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
