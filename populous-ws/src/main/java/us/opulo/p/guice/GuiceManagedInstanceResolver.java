/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.guice;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebServiceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.sun.xml.ws.api.message.Packet;
import com.sun.xml.ws.api.server.WSEndpoint;
import com.sun.xml.ws.api.server.WSWebServiceContext;
import com.sun.xml.ws.server.AbstractMultiInstanceResolver;

/**
 * This source code contains snippets from various internet websites and repositories. 
 * The original code may have been a part of the Guicyfruit project.
 */
public class GuiceManagedInstanceResolver<T> extends AbstractMultiInstanceResolver<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuiceManagedInstanceResolver.class);

    private static Injector injector;

    private transient WSWebServiceContext webServiceContext;

    public GuiceManagedInstanceResolver(final Class<T> clazz) {
        super(clazz);
    }

    @Override
    public T resolve(final Packet request) {
        final T instance = injector.getInstance(this.clazz);
        injector.injectMembers(instance);

        return instance;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void start(final WSWebServiceContext wsWebServiceContext, final WSEndpoint endpoint) {
        super.start(wsWebServiceContext, endpoint);
        this.webServiceContext = wsWebServiceContext;

        synchronized (GuiceManagedInstanceResolver.class) {
            if (injector == null) {
                final List<Module> moduleInstances = new ArrayList<Module>();
                final Class<? extends Module>[] modules = this.clazz.getAnnotation(GuiceManaged.class).modules();

                for (final Class<? extends Module> moduleClass : modules) {
                    try {
                        moduleInstances.add(moduleClass.newInstance());
                    } catch (final InstantiationException exception) {
                        LOGGER.error("Could not instantiate guice module [{}]", moduleClass.getName());
                    } catch (final IllegalAccessException e) {
                        LOGGER.error("Could not instantiate guice module [{}]", moduleClass.getName());
                    }
                }

                moduleInstances.add(new AbstractModule() {
                    @Override
                    protected void configure() {
                        this.bind(WebServiceContext.class).toInstance(GuiceManagedInstanceResolver.this.webServiceContext);
                    }
                });

                injector = Guice.createInjector(moduleInstances);
            }
        }
    }
}
