package edu.sjsu.voidstar.jaxb.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Specify the location of the schema the EntityMarshaller
 * @author Jason Campos
 */
@Retention(RUNTIME) 
@Target(TYPE)
public @interface SchemaLocation {
	String value() default "";
}
