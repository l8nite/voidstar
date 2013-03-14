/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.jaxb.tables;

import java.util.Collection;
import java.util.List;

import us.p.opulo.dao.HEntity;

/**
 * Database table JAXB binding interface.
 * @author Jason Campos
 * @param <E> Entity class being bound by the implementing class.
 */
public interface EntityTable <E extends HEntity> {
	/**
	 * @param entity The entity being added to the table being marshalled/unmarshalled by this wrapper. 
	 */
	public abstract void add(E entity);
	
	/**
	 * @param entities The collection of entities being added to the table being marshalled/unmarshalled by this wrapper.
	 */
	public void addAll(Collection<E> entities);
	
	/**
	 * @return returns the collection of entities being marshalled/unmarshalled by this wrapper.
	 */
	public List<E> getEntities();
}
