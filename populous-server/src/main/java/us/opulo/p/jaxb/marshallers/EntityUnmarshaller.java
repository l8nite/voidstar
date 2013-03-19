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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.HEntity;
import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.jaxb.tables.EntityTable;
import us.opulo.p.util.Assertions;

/**
 * Class responsible for unmarshalling XML of HENtitys
 * 
 * @author Jason Campos
 * @param <T> The Entity class being unmarshalled.
 */
public class EntityUnmarshaller <E extends HEntity> {
	private static final Logger log = LoggerFactory.getLogger(EntityUnmarshaller.class);
	
	private JAXBContext context;
	private Unmarshaller unmarshaller;
	
	/**
	 * Creates an EntityUnmarshaller for the argument entityClass. The argument class must be annotated with the {@code @XmlGroup} 
	 * annotation and the XML document being parsed must match the format of the class returned from the annotation.  
	 *  
	 * @param entityClass The class of the entities being unmarshalled.
	 * @return An EntityUnmarshaller capable of unmarshalling objects of the argument entityClass.
	 */
	public static <E extends HEntity> EntityUnmarshaller<E> create(Class<E> entityClass) {
		Assertions.assertAnnotationPresent(entityClass, XmlGroup.class);
		
		@SuppressWarnings("unchecked")
		Class<EntityTable<E>> tableClass = (Class<EntityTable<E>>) entityClass.getAnnotation(XmlGroup.class).value();
		
		return new EntityUnmarshaller<E>(tableClass);
	}
	
	/*
	 * (non-javadoc)
	 * Private constructor. Public facing API is the factory create() method. 	 
	 */
	private EntityUnmarshaller(Class<? extends EntityTable<?>> entityTableClass) {	
		try {
			this.context = JAXBContext.newInstance( new Class[] { entityTableClass } );
			this.unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Parses the argument XML file and returns a list of unmarshalled objects. 
	 * @param file The XML file to parse
	 * @return A {@code List} of objects unmarshalled from the XML. 
	 * @throws FileNotFoundException
	 * @throws JAXBException
	 */
	public List<E> unmarshal(File file) throws FileNotFoundException, JAXBException {
		return unmarshal(new FileInputStream(file));
	}
	
	/**
	 * Parses the argument input stream as XML and returns a list of unmarshalled objects.
	 * @param is The input stream of XML
	 * @return A {@code List} of objects unmarshalled from the XML
	 * @throws JAXBException
	 */
	public List<E> unmarshal(InputStream is) throws JAXBException {
		EntityTable<E> entityTable = unmarshalFromXml(is);
		return entityTable.getEntities();
	}

	/*
	 * (non-javadoc)
	 * Unmarshals the argument unput stream into the an entity table. 
	 */
	@SuppressWarnings("unchecked")
	private EntityTable<E> unmarshalFromXml(InputStream is) throws JAXBException {
		return (EntityTable<E>) unmarshaller.unmarshal(is);
	}
}

