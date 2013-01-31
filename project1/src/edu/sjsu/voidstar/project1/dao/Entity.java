package edu.sjsu.voidstar.project1.dao;

import edu.sjsu.voidstar.project1.hibernate.HibernateSession;

public class Entity {
	
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
		return this.hashCode(); 
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO
		return this.equals(o);
	}
}