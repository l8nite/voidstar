package us.opulo.p.guice.webservice;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;


import com.google.inject.Module;
import com.sun.xml.ws.api.server.InstanceResolverAnnotation;

@Retention(RUNTIME)
@Target(TYPE)
@Documented
@WebServiceFeatureAnnotation(id=GuiceManagedFeature.ID, bean=GuiceManagedFeature.class)
@InstanceResolverAnnotation(GuiceManagedInstanceResolver.class)
public @interface GuiceManaged {
	Class<? extends Module>[] modules();
}