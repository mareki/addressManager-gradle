package com.acme.am.web.security;

import org.jboss.seam.security.Identity;
import org.jboss.seam.security.annotations.Secures;

import com.acme.am.web.annotations.UserLoggedIn;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
public class SecurityRules {

  @Secures
  @UserLoggedIn
  public boolean isUserLoggedIn(Identity identity) {
    return identity.getUser() != null;
  }

}
