package com.acme.am.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.acme.am.dao.ContactDao;
import com.acme.am.dao.UserDao;
import com.acme.am.domain.Contact;
import com.acme.am.domain.User;

/**
 * @author Moritz Zimmer
 * @author <a href="mailto:marek.iwaszkiewicz@akquinet.de">Marek
 *         Iwaszkiewicz</a>
 */
@Stateless
public class UserServiceBean implements UserService {

	@EJB
	private UserDao userDao;

	@EJB
	private ContactDao taskDao;

	// -------------- interface method implementations
	// ------------------------------------

	@Override
	public User loadById(final Long userId) {
		return userDao.load(userId);
	}

	@Override
	public User loadByUsername(final String username) {
		return userDao.loadByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		userDao.persist(user);
	}

	@Override
	public void mergeUser(User user) {
		userDao.persist(user);
	}

	@Override
	public void removeUser(User user) {

		List<Contact> tasksToRemove = taskDao.findForUser(user);

		if (!tasksToRemove.isEmpty()) {

			for (Contact task : tasksToRemove) {
				taskDao.delete(task);
			}
		}

		userDao.delete(loadById(user.getId()));
	}

	@Override
	public List<User> loadAll() {
		return userDao.loadAll();
	}

}
