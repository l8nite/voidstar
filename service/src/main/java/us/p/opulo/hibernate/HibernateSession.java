/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.hibernate;

import org.hibernate.Session;

import com.google.inject.ImplementedBy;

/**
 * This class is responsible for maintaining a persistent Session for the life of the program 
 * and for managing transactions.  
 * 
 * @author Jason Campos
 */
@ImplementedBy(HibernateSessionImpl.class)
public interface HibernateSession {
	/**
	 * @return The Session object on which Criteria and/or queries may be executed
	 */
	public Session get();
	
	/**
	 * Starts a new database Transaction.
	 */
	public void beginTransaction();
	
	/**
	 * Commits a database transaction. 
	 */
	public void commitTransaction();
	
	/**
	 * Rolls back a databse transaction.
	 */
	public void rollbackTransaction();
	
	/**
	 * @return The <code>HibernateConfig</code> used for this session.
	 */
	public HibernateConfig getConfig();
}
