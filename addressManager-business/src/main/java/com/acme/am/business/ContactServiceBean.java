package com.acme.am.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.acme.am.dao.ContactDao;
import com.acme.am.domain.Contact;
import com.acme.am.domain.User;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@Stateless
public class ContactServiceBean implements ContactService {

	@EJB
	private ContactDao contactDao;

	// -------------- interface method implementations
	// ------------------------------------

	@Override
	public List<Contact> loadContactsForUser(User user) {
		return contactDao.findForUser(user);
	}

	@Override
	public void saveContact(Contact contact) {
		contactDao.persist(contact);
	}

	@Override
	public void deleteContact(final Long contactId) {
		Contact contact = contactDao.load(contactId);
		if (contact != null) {
			contactDao.delete(contact);
		}
	}

}
