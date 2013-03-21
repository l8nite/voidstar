/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.hibernate;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides basic Session management for hibernate. Tracks Sessions on a per-thread basis. Does NOT include 
 * automatic session closing. Care must be taken to close open Hibernate connections.
 *  
 * @author Jason Campos
 */
public class SessionManager {
	private static final Logger log = LoggerFactory.getLogger(SessionManager.class);
	
	// The active sessions
	private static final ThreadLocal<Session> ACTIVE_SESSIONS = new ThreadLocal<>();
	
	private static final String DUPLICATE_SESSION = "An active session is already open for this thread.";
	private static final String INVALID_SESSION = "No active session exists for this thread.";	
	
	/**
	 * Set the Session for the current thread.
	 * @param session The Hibernate Session which belongs to this thread.
	 * @throws IllegalStateException Thrown if a session already exists.
	 */
	public static synchronized final void set(Session session) {
		log.debug("Session initialized");
		if(ACTIVE_SESSIONS.get() != null) {
			throw new IllegalStateException(DUPLICATE_SESSION);
		}
		
		// Set the session for the current thread
		ACTIVE_SESSIONS.set(session);
	}
	
	/**
	 * Retrieves the Session for the current thread.
	 * @return The Session for the current thread of {@code null} if one does not exist.
	 */
	public static synchronized final Session get() {
		return ACTIVE_SESSIONS.get();
	}
	
	/**
	 * Closes the session for the current thread.
	 * @throws IllegalStateException Thrown if the session is already closed. 
	 */
	public static synchronized final void close() {
		Session session = ACTIVE_SESSIONS.get();
		
		if (session == null) {
			throw new IllegalStateException(INVALID_SESSION);
		}
		
		if (session.isConnected()) {
			session.flush();
			session.disconnect();
			session.close();
			ACTIVE_SESSIONS.remove();
			log.debug("Session closed");
		}
	}
}
