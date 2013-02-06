package edu.sjsu.voidstar.project1.hibernate;

import org.junit.Test;

public class HibernateSessionTest {

	@Test
	public void testConnectionSuccessful() {
		HibernateSession.get();
	}
}
