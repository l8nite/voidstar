/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.jaxb.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import us.opulo.p.jaxb.tables.EntityTable;

/**
 * Used for XML marshalling/unmarshalling to specify the JAXB "Table" to use for grouping. 
 * @author Jason Campos
 */
@Retention(RUNTIME) 
@Target(TYPE)
public @interface XmlGroup {
	Class<? extends EntityTable<?>> value();
}
