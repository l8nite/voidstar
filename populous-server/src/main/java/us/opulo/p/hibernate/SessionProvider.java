/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.hibernate;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import us.opulo.p.dao.HEntity;

import com.google.inject.Provider;

/**
 * Singleton provider for the hibernate connection pool. Classes implementing 
 * <code>HibernateSession</code> should inject an instance of this provider 
 * and invoke {@link #get()} to obtain the proper Session. 
 * 
 * @author Jason Campos
 */
@Singleton
public class SessionProvider implements Provider<Session> {
	
	private final SessionFactory sessionFactory;

	/**
	 * Initializes a SessionFactory configured using the argument config. 
	 * Invocations of {@link #get()} will serve from the this SessionFactory.
	 *  
	 * @param config The HibernateConfig used for establishing the database connection.
	 */
	@Inject
	public SessionProvider (HibernateConfig config){
		this.sessionFactory = initializeSessionFactory(config);
	}
	
	@Override
	public Session get() {
		Session session = SessionManager.get();
		if (session == null) {
			session = sessionFactory.openSession();
			SessionManager.set(session);
		}
		return session;
	}

	/*
	 * (non-Javadoc)
	 * Initializes the hibernate connection and sets the session property
	 */
	private SessionFactory initializeSessionFactory(HibernateConfig config) {
		Configuration conf = new Configuration();
		conf.setProperties(config.getProperties());

		for (Class<? extends HEntity> entityClass : config.getClasses()) {
			conf.addAnnotatedClass(entityClass);
		}
	
		return conf.buildSessionFactory();
	}
}
