package com.acme.am.business.it;

import org.junit.Assert;
import org.junit.Test;

import com.acme.am.domain.User;

public class UserServiceIntegrationTest {

	@Test
	public void testLoadByUsername() throws Exception {

		final User user1 = new User("xXx", "xXx", "vin", "disel", "triple@xXx.com");
		final User user2 = new User("spiderman", "spiderman", "peter", "parker", "peter.parker@marvel.com");

		Assert.assertNotSame(user1, user2);
	}

}
