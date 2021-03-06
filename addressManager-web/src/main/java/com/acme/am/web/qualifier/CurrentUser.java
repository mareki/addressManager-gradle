package com.acme.am.web.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.SessionScoped;
import javax.inject.Qualifier;

/**
 * @author Moritz Zimmer
 * @author Marek Iwaszkiewicz
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@SessionScoped
public @interface CurrentUser {
}
