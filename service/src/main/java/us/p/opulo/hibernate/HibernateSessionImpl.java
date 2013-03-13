/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.hibernate;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import us.p.opulo.dao.HEntity;

/**
 * This class is responsible for maintaining a persistent Session for the life of the program 
 * and for managing transactions.  
 * 
 * @author Jason Campos
 */
@Singleton
public class HibernateSessionImpl implements HibernateSession {
	
	private Session session;
	private HibernateConfig module;
	private Transaction transaction;

	@Inject
	public HibernateSessionImpl(HibernateConfig module) {
		this.module = module;
		initialize();
		assertInitialized();
	}
	
	public Session get() {
		return session;
	}
	
	/**
	 * Starts a new database Transaction.
	 */
	public void beginTransaction() {
		assertInitialized();
		assertNoPendingTransaction();
		transaction = session.beginTransaction();
	}
	
	/**
	 * Commits a database transaction. 
	 */
	public void commitTransaction() {
		assertPendingTransaction();
		
		try {
			transaction.commit();
		} catch (HibernateException he) {
			System.err.println(he);
			he.printStackTrace(System.err);
		} finally {
			transaction = null;
		}
	}
	
	/**
	 * Rolls back a databse transaction.
	 */
	public void rollbackTransaction() {
		assertInitialized();
		assertPendingTransaction();
		
		try {
			transaction.rollback();
		} catch (HibernateException he) {
			System.err.println(he);
			he.printStackTrace(System.err);
		} finally {
			transaction = null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * Initializes the hibernate connection and sets the session property
	 */
	private void initialize() {
		SessionFactory sessionFactory = null;
		Configuration config = loadConfiguration();
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	
	/*
	 * (non-Javadoc)
	 * Returns a Configuration object initialized using the settings from the argument HibernateModule.
	 */
	private Configuration loadConfiguration() {
		Configuration config = new Configuration();
		config.setProperties(module.getProperties());

		for (Class<? extends HEntity> entityClass : module.getClasses()) {
			config.addAnnotatedClass(entityClass);
		}
		
		return config;
	}
	
	/*
	 * (non-Javadoc)
	 * Throws a RuntimeException if hibernateSession has not been initialized.
	 */
	private void assertInitialized() {
		if(session == null){
			throw new RuntimeException("Unable to initialize Hibernate.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * Throws a HibernateException if transaction is null.
	 */
	private void assertPendingTransaction() {
		if(transaction == null){
			throw new HibernateException("No Transaction is active.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * Throws a HibernateException if transaction is not null.
	 */
	private void assertNoPendingTransaction() {
		if(transaction != null){
			rollbackTransaction();
			throw new HibernateException("A Transaction is already active.");
		}
	}
}
