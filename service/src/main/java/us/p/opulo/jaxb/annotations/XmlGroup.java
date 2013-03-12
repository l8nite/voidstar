package us.p.opulo.jaxb.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import us.p.opulo.jaxb.tables.EntityTable;

@Retention(RUNTIME) 
@Target(TYPE)
public @interface XmlGroup {
	Class<? extends EntityTable<?>> value();
}
