package com.acme.am.business;

import java.util.List;

import javax.ejb.Local;

import com.acme.am.domain.User;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@Local
public interface UserService {

  User loadById(final Long userId);
  
  User loadByUsername(final String username);
  
  void saveUser(final User user);

  void mergeUser(final User user);

  void removeUser(final User user);

  List<User> loadAll();

}
