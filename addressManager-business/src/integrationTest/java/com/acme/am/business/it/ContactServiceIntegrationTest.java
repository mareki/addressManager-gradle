package com.acme.am.business.it;

import org.junit.Test;

import com.acme.am.business.ContactService;
import com.acme.am.business.ContactServiceBean;
import com.acme.am.business.UserService;
import com.acme.am.business.UserServiceBean;
import com.acme.am.dao.ContactDao;
import com.acme.am.dao.ContactDaoBean;
import com.acme.am.dao.UserDao;
import com.acme.am.dao.UserDaoBean;

import de.akquinet.jbosscc.needle.annotation.InjectInto;
import de.akquinet.jbosscc.needle.annotation.ObjectUnderTest;

public class ContactServiceIntegrationTest {

	@SuppressWarnings("unused")
	@ObjectUnderTest
	@InjectInto(targetComponentId = "userService")
	private final UserDao userDao = new UserDaoBean();

	@ObjectUnderTest
	private final ContactService contactService = new ContactServiceBean();

	@ObjectUnderTest
	@InjectInto(targetComponentId = "userService")
	private final ContactDao taskDao = new ContactDaoBean();

	// -------------- test methods
	// --------------------------------------------------------

	@Test
	public void testSaveAndDeleteContact() throws Exception {

	}

	@Test
	public void listContactsForUser() throws Exception {

	}

}
