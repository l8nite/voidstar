package edu.sjsu.voidstar.proj1.hibernate;

import org.hibernate.Session;

public class HibernateSession {

	private static Session hibernateSession;
	
	private HibernateSession() { 
		throw new AssertionError("Cannot instantion class " + this.getClass().getSimpleName());
	}
	
	public static synchronized Session get() {
		if (hibernateSession == null) { 
			// TODO
		}
		return hibernateSession;
	}
}
