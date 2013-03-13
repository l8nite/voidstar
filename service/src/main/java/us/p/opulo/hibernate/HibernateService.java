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

import us.p.opulo.dao.HEntity;

import com.google.inject.ImplementedBy;

/**
 * Service class for any common Hibernate queries.
 * @author Jason Campos
 */
@ImplementedBy(HibernateServiceImpl.class)
public interface HibernateService {

	/**
	 * Fetches all entities from the database for the argument entityClass.
	 * @param entityClass
	 * @return A list of all persisted objects matching the argument entityClass.
	 */
	public <T extends HEntity> List<T> fetchAll(Class<T> entityClass);
	
	/**
	 * Deletes all entities in the database for the argument class.
	 * @param entityClass The entity class which should have all entries from the database removed.
	 * @return The number of deleted entries
	 */
	public <T extends HEntity> int deleteAll(Class<T> entityClass);
	
	/**
	 * Deletes all rows from the database for every entity class loaded from the configuration.
	 */
	public void resetDatabase();
}
