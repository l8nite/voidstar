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
public class HibernateSession {
	
	private static Session hibernateSession;
	private static Transaction transaction;
	
	/**
	 * @return The application's current Hibernate Session object.
	 */
	public static Session get() {
		if (!isInitialized()) {
			initialize();
		}
		assertInitialized();
		return hibernateSession;
	}
	
	/**
	 * Starts a new database Transaction.
	 */
	public static void beginTransaction() {
		assertInitialized();
		assertNoPendingTransaction();
		transaction = hibernateSession.beginTransaction();
	}

	/**
	 * Commits a database transaction. 
	 */
	public static void commitTransaction() {
		assertInitialized();
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
	public static void rollbackTransaction() {
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
	 * Throws a RuntimeException if hibernateSession has not been initialized.
	 */
	private static void assertInitialized() {
		if(!isInitialized()){
			throw new RuntimeException("The HibernateSession has not been initialized. Use HibernateSession.get() to initialize.");
		}
	}

	/*
	 * (non-Javadoc)
	 * Returns true if hibernateSession is not null.
	 */
	private static boolean isInitialized() {
		return hibernateSession != null;
	}
	
	/*
	 * (non-Javadoc)
	 * Throws a HibernateException if transaction is null.
	 */
	private static void assertPendingTransaction() {
		if(transaction == null){
			throw new HibernateException("No Transaction is active.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * Throws a HibernateException if transaction is not null.
	 */
	private static void assertNoPendingTransaction() {
		if(transaction != null){
			rollbackTransaction();
			throw new HibernateException("A Transaction is already active.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * Intializes the hibernateSession variable.
	 */
	private static void initialize() {
		SessionFactory sessionFactory = null;
		Configuration config = loadConfiguration(new HibernateModule());
		sessionFactory = config.buildSessionFactory();
		hibernateSession = sessionFactory.openSession();
}

	/*
	 * (non-Javadoc)
	 * Returns a Configuration object initialized using the settings from the argument HibernateModule.
	 */
	private static Configuration loadConfiguration(HibernateModule module) {
		Configuration config = new Configuration();
		config.setProperties(module.getProperties());

		for (Class<? extends HEntity> entityClass : module.getClasses()) {
			config.addAnnotatedClass(entityClass);
		}
		
		return config;
	}
}
