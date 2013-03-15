/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlTransient;

import us.opulo.p.hibernate.HibernateSession;

/**
 * Base class for all DAO objects being persisted using Hibernate. This class provides shortcuts for
 * saving, updating, and deleting objects in persistent storage.
 * 
 * @author Jason Campos
 */
@XmlTransient
public class HEntity {
	
	@Inject
	protected static HibernateSession session;
	
	/**
	 * Persists the entity.
	 */
	public void save() {
		session.get().save(this);
	}
	
	/**
	 * Updates the persistent entity.
	 */
	public void update() { 
		session.get().update(this);
	}
	
	/**
	 * Deletes the persistent entity.
	 */
	public void delete() {
		session.get().delete(this);
	}
}
