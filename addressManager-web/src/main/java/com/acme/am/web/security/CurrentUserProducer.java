package com.acme.am.web.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.idm.impl.api.model.SimpleUser;

import com.acme.am.web.qualifier.CurrentUser;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@SessionScoped
public class CurrentUserProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DummyAuthenticator authenticator;

	@Produces
	@Named
	@CurrentUser
	public SimpleUser getCurrentUser() {
		return (SimpleUser) authenticator.getUser();
	}
}
