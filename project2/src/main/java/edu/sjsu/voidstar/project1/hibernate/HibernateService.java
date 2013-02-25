package edu.sjsu.voidstar.project1.hibernate;

import java.util.List;

import edu.sjsu.voidstar.project1.dao.HEntity;

/**
 * Service class for any common Hibernate queries.
 * @author Jason Campos
 */
public class HibernateService {
	
	/**
	 * Fetches all entities from the database for the argument entityClass.
	 * @param entityClass
	 * @return A list of all persisted objects matching the argument entityClass.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends HEntity> List<T> fetchAll(Class<T> entityClass) {
		return HibernateSession.get()
				.createCriteria(entityClass)
				.list();
	}
}
