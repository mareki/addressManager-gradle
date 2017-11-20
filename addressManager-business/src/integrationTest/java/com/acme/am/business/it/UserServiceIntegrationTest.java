package com.acme.am.business.it;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.acme.am.business.UserService;
import com.acme.am.business.it.util.ArquillianHelper;
import com.acme.am.domain.User;

@RunWith(Arquillian.class)
public class UserServiceIntegrationTest {

	@Inject
	private UserService userService;

	@Deployment(testable=true)
	public static WebArchive createWebArchive() {
		final WebArchive webArchive = ArquillianHelper.testWebArchive;
		return webArchive;
	}

	@Test
	public void testLoadByUsername() throws Exception {

		final User user1 = new User("xXx", "xXx", "vin", "disel", "triple@xXx.com");
		final User user2 = new User("spiderman", "spiderman", "peter", "parker", "peter.parker@marvel.com");

		userService.saveUser(user1);
		userService.saveUser(user2);

		User xXx = userService.loadByUsername("xXx");
		Assert.assertNotNull(xXx);

		User spiderman = userService.loadByUsername("spiderman");
		Assert.assertNotNull(spiderman);

		User hulk = userService.loadByUsername("hulk");
		Assert.assertNull(hulk);
	}

}
