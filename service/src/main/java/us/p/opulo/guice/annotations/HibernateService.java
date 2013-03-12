package us.p.opulo.guice.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@Retention(RUNTIME) 
@Target({FIELD, LOCAL_VARIABLE, CONSTRUCTOR})
@BindingAnnotation
public @interface HibernateService {}
