package com.acme.am.business.it;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.acme.am.business.ContactService;
import com.acme.am.business.it.util.ArquillianHelper;
import com.acme.am.dao.UserDao;
import com.acme.am.domain.Address;
import com.acme.am.domain.Contact;
import com.acme.am.domain.User;

@RunWith(Arquillian.class)
public class ContactServiceIntegrationTest {

	@Inject
	private UserDao userDao;

	@Inject
	private ContactService contactService;

	@Deployment(testable=true)
	public static WebArchive createWebArchive() {
		final WebArchive webArchive = ArquillianHelper.testWebArchive;
		return webArchive;
	}

	@Test
	public void testSaveLoadAndDeleteContact() throws Exception {
		
		User spiderman = new User("spidy", "secure", "Peter", "Parker", "pete@parker.com");
		userDao.persist(spiderman);
		
		Address address = new Address("street", "12", "NY", "USA", "10101");
		Contact contact = new Contact("Tony", "Stark", "ironman@stark.com", address, spiderman);
		contactService.saveContact(contact);
		
		List<Contact> contactsReloaded = contactService.loadContactsForUser(spiderman);
		Assert.assertNotNull(contactsReloaded);
		Assert.assertEquals(1, contactsReloaded.size());
		
		Assert.assertEquals(contact.getId(), contactsReloaded.get(0).getId());
		
		contactService.deleteContact(contactsReloaded.get(0).getId());
		
		contactsReloaded = contactService.loadContactsForUser(spiderman);
		Assert.assertTrue(contactsReloaded.isEmpty());

	}

}
