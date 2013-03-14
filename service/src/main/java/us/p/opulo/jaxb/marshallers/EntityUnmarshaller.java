/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.jaxb.marshallers;

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

import us.p.opulo.dao.HEntity;
import us.p.opulo.jaxb.annotations.XmlGroup;
import us.p.opulo.jaxb.assertions.JAXBAssertions;
import us.p.opulo.jaxb.tables.EntityTable;

/**
 * Class responsible for unmarshalling XML from EntityTable XML.
 * 
 * @author Jason Campos
 * @param <T> The EntityTable class being unmarshalled.
 */
public class EntityUnmarshaller <E extends HEntity> {
	private static final Logger log = LoggerFactory.getLogger(EntityUnmarshaller.class);
	
	private JAXBContext context;
	private Unmarshaller unmarshaller;
	
	public static <E extends HEntity> EntityUnmarshaller<E> create(Class<E> entityClass) {
		JAXBAssertions.assertXmlGroupAnnotationIsPresent(entityClass);
		
		@SuppressWarnings("unchecked")
		Class<EntityTable<E>> tableClass = (Class<EntityTable<E>>) entityClass.getAnnotation(XmlGroup.class).value();
		
		return new EntityUnmarshaller<E>(tableClass);
	}
	
	private EntityUnmarshaller(Class<? extends EntityTable<?>> entityTableClass) {	
		try {
			this.context = JAXBContext.newInstance( new Class[] { entityTableClass } );
			this.unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public List<E> unmarshal(File file) throws FileNotFoundException, JAXBException {
		return unmarshal(new FileInputStream(file));
	}
	
	public List<E> unmarshal(InputStream is) throws JAXBException {
		EntityTable<E> entityTable = unmarshalFromXml(is);
		return entityTable.getEntities();
	}

	@SuppressWarnings("unchecked")
	private EntityTable<E> unmarshalFromXml(InputStream is) throws JAXBException {
		return (EntityTable<E>) unmarshaller.unmarshal(is);
	}
}

