package com.acme.am.dao;

import javax.ejb.Local;

import com.acme.am.dao.common.GenericDao;
import com.acme.am.domain.User;

/**
 * @author Marek Iwaszkiewicz
 * @author Moritz Zimmer
 */
@Local
public interface UserDao extends GenericDao<User> {

  User loadByUsername(final String username);

}
