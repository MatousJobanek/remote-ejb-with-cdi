package org.jboss.weld.remote.ejb.with.cdi.server.side.util.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Qualifier
@Target({FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrement {

}