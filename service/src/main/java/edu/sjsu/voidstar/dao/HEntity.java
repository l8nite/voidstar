package edu.sjsu.voidstar.dao;

import javax.xml.bind.annotation.XmlTransient;

import edu.sjsu.voidstar.hibernate.HibernateSession;

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