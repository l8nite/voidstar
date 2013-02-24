package edu.sjsu.voidstar.project1.dao;

import javax.xml.bind.annotation.XmlTransient;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

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
