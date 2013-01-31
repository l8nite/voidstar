package edu.sjsu.voidstar.project1.hibernate;

import java.util.Stack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.sjsu.voidstar.project1.dao.Entity;

/**
 * This class is responsible for maintaining a persistent Session for the life of the program 
 * and for managing transactions.  
 * 
 * @author Jason Campos
 */
public class HibernateSession {
	
	private static Session hibernateSession;
	private static Stack<Transaction> transactions = new Stack<>();
	private static int pendingTransactions = 0;
	
	public static Session get() {
		ensureInitialized();
		return hibernateSession;
	}
	
	private static void initializeSession() {
		SessionFactory sessionFactory = null;
		HibernateModule module = new HibernateModule();
		try {
			Configuration config = new Configuration();
			config.setProperties(module.getProperties());
			
			for (Class<? extends Entity> entityClass : module.getClasses()) {
				config.addClass(entityClass);
			}
			
			config.configure();
			hibernateSession = config.buildSessionFactory().openSession();
		} finally {
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

	public static void beginTransaction() {
		ensureInitialized();
		transactions.add(hibernateSession.beginTransaction());
		pendingTransactions++;
	}
	
	public static void commitTransaction() {
		if(transactions.isEmpty()) {
			throw new IllegalStateException("No pending transactions to commit during call to commitTransaction()");
		}
		ensureInitialized();
		
		pendingTransactions--;
		
		// Only commit the transactions if this is the outermost transaction
		if(pendingTransactions != 0)
			return;
		
		for(Transaction txToCommit : transactions){
			try {
				txToCommit.commit();
			} catch (HibernateException he) {
				System.err.println(he);
				he.printStackTrace(System.err);
			} 
		}	
	}
	
	public static void rollbackTransaction() {
		if(transactions.isEmpty()) {
			throw new IllegalStateException("No pending transactions to commit during call to rollbackTransaction()");
		}
		transactions.pop();
	}
	
	private static void ensureInitialized() {
		if(!isInitialized()){
			initializeSession();
		}
	}

	private static boolean isInitialized() {
		return hibernateSession != null;
	}
}
