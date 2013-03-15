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

@XmlTransient
public class HEntity {
	
	@Inject
	protected static HibernateSession session;
	
	public void save() {
		session.get().save(this);
	}
	
	public void update() { 
		session.get().update(this);
	}
	
	public void delete() {
		session.get().delete(this);
	}
	
	@Override
	public int hashCode() {
		// TODO
		return super.hashCode(); 
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO
		return super.equals(o);
	}
}
