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

import java.util.List;
import java.util.Properties;

import us.opulo.p.dao.HEntity;

import com.google.inject.ImplementedBy;

/**
 * Contains configuration data for the Hibernate connection. 
 */
@ImplementedBy(HibernateConfigImpl.class)
public interface HibernateConfig {
	
	/**
	 * @return A list of classes that map to Hibernate entitities
	 */
	List<Class<? extends HEntity>> getClasses();
	
	/**
	 * @return Configuration properties for Hibernate.
	 */
	Properties getProperties();
}
