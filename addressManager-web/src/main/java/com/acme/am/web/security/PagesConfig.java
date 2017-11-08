package com.acme.am.web.security;

import org.jboss.seam.faces.rewrite.FacesRedirect;
import org.jboss.seam.faces.security.LoginView;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;

import com.acme.am.web.annotations.UserLoggedIn;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@ViewConfig
public class PagesConfig {

	static enum Pages {

		@ViewPattern("/pages/addresses/*")
		@UserLoggedIn
		SECURED,

		@FacesRedirect
		@ViewPattern("/pages/*")
		@LoginView("/login")
		ALL
	}
}
