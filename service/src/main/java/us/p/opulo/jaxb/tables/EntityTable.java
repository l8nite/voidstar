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
