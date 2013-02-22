package edu.sjsu.voidstar.project2.jaxb.factory;

import java.lang.reflect.ParameterizedType;

import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

public class XmlFactory <T extends EntityTable<E>, E extends HEntity>{
	
	// Cache reflected object
	Class<T> tableClass;
	Class<E> rowClass;
	
	@SuppressWarnings("unchecked")
	public final T createTable(){
		// Get the EntityTable parameter for this class instance
		if (tableClass == null) {
			ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
			tableClass = (Class<T>) superClass.getActualTypeArguments()[0];
		}
		
		// Create new instance using the no argument constructor
		T tableInstance = null;
		try {
			tableInstance = tableClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		
		return tableInstance;
	}
	
	@SuppressWarnings("unchecked")
	public final E createRow() {
		// Get the HEntity parameter for this class instance
		if (rowClass == null) {
			ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
			rowClass = (Class<E>) superClass.getActualTypeArguments()[1];
		}
		
		E rowInstance = null;
		try {
			rowInstance = rowClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		
		return rowInstance;
	}
}
