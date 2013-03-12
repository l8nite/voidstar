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
package us.p.opulo.hibernate;

import java.util.List;

import javax.persistence.Table;

import us.p.opulo.dao.HEntity;
import us.p.opulo.util.Assertions;

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
	
	public static <T extends HEntity> int deleteAll(Class<T> entityClass) {
		Assertions.assertAnnotationPresent(entityClass,Table.class);
		
		String tableName = entityClass.getAnnotation(Table.class).name();
		return HibernateSession.get()
				.createQuery("delete from " + tableName)
				.executeUpdate();
	}

	public static void resetDatabase() {
		// TODO: Another reason to use some sort of dependency injection like Guice
		HibernateModule module = new HibernateModule(); 
		for(Class<? extends HEntity> c : module.getClasses()) {
			deleteAll(c);
		}
	}
}
