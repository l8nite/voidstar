/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.jaxb.marshallers;

import java.io.OutputStream;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.HEntity;
import us.opulo.p.jaxb.annotations.SchemaLocation;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.EntityTable;
import us.opulo.p.util.Assertions;

/**
 * Class responsible for marshalling EntityTable/HEntity objects to XML.
 * 
 * @author Jason Campos
 * @param <E> The Entity class being marshalled
 */
public class EntityMarshaller <E extends HEntity>{
	private static final Logger log = LoggerFactory.getLogger(EntityMarshaller.class);
	
	// The EntityTable object holding the collection of Entities to marshal.
	private Class<? extends EntityTable<E>> tableClass;
	private EntityTable<E> table;
	
	/**
	 * Creates an EntityMarshaller for the argument entityClass. The argument class must be annotated with the {@code @XmlGroup} 
	 * annotation in order to be properly marshalled into the correct binding. 
	 * 
	 * @param entityClass The entity class being marshalled.
	 * @return An EntityMarshaller capable of marshalling entities of the argument entityClass into the correct binding.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <E extends HEntity> EntityMarshaller<E> create(Class<E> entityClass) throws InstantiationException, IllegalAccessException {
		Assertions.assertAnnotationPresent(entityClass, XmlGroup.class);
		XmlGroup group = entityClass.getAnnotation(XmlGroup.class);
		
		// Runtime error if the tableclass's type parameter does not match E
		@SuppressWarnings("unchecked")
		Class<? extends EntityTable<E>> tableClass = (Class<? extends EntityTable<E>>) group.value();
		
		return new EntityMarshaller<E>(tableClass);
	}
	
	/*
	 * (non-javadoc)
	 * Private constructor. Public facing API is to use the factory method create().
	 */
	private <T extends EntityTable<E>> EntityMarshaller(Class<T> tableClass) throws InstantiationException, IllegalAccessException {
		this.tableClass = tableClass;
		this.table = tableClass.newInstance();	
	}

	/**
	 * Add an entity to the XML
	 * @param entity The entity to add to the XML.
	 */
	public void add(E entity) {
		table.add(entity);
	}
	
	/**
	 * Add a collection of entities to the XML
	 * @param entities The entities to add to the XML.
	 */
	public void addAll(Collection<E> entities) {
		table.addAll(entities);
	}
	
	/**
	 * Marshals output to System.out
	 */
	public void marshal() {			
		marshal(System.out);
	}
	
	/**
	 * Marshals output to the specified output stream.
	 * @param out The output stream to which the marshalled XML should be written.
	 */
	public void marshal(OutputStream out) {
		try {
			JAXBContext context = JAXBContext.newInstance(new Class[]{tableClass});
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// If the class has the SchemaLocation annotation, set the schema location
			if(tableClass.isAnnotationPresent(SchemaLocation.class)) {
				SchemaLocation location = tableClass.getAnnotation(SchemaLocation.class);
				marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, location.value());
			}
			
			marshaller.marshal(table, out);
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
}
