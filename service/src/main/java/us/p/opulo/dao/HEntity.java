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
package us.p.opulo.dao;

import javax.xml.bind.annotation.XmlTransient;

import us.p.opulo.hibernate.HibernateSession;

@XmlTransient
public class HEntity {
	
	public void save() {
		HibernateSession.get().save(this);
	}
	
	public void update() { 
		HibernateSession.get().update(this);
	}
	
	public void delete() {
		HibernateSession.get().delete(this);
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
