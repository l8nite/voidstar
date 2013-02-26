package edu.sjsu.voidstar.project2.jaxb.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

@Retention(RUNTIME) 
@Target(TYPE)
public @interface XmlGroup {
	Class<? extends EntityTable<?>> value();
}
