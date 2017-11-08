package com.acme.am.dao;

import java.util.List;

import javax.ejb.Local;

import com.acme.am.dao.common.GenericDao;
import com.acme.am.domain.Contact;
import com.acme.am.domain.User;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@Local
public interface ContactDao extends GenericDao<Contact> {

	List<Contact> findForUser(User user);

}
