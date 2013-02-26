package edu.sjsu.voidstar.project2.jaxb.marshallers;

import java.io.OutputStream;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project2.jaxb.annotations.SchemaLocation;
import edu.sjsu.voidstar.project2.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.project2.jaxb.assertions.JAXBAssertions;
import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

/**
 * Class responsible for marshalling EntityTable/HEntity objects to XML.
 * 
 * @author Jason Campos
 * @param <T> The EntityTable wrapper responsible for marshalling the Entity
 * @param <E> The Entity being marshalled
 */
public class EntityMarshaller <E extends HEntity>{
	private static final Logger log = LoggerFactory.getLogger(EntityMarshaller.class);
	
	// The EntityTable object holding the collection of Entities to marshal.
	private Class<? extends EntityTable<E>> tableClass;
	private EntityTable<E> table;
	
	public static <E extends HEntity> EntityMarshaller<E> create(Class<E> entityClass) throws InstantiationException, IllegalAccessException {
		JAXBAssertions.assertXmlGroupAnnotationIsPresent(entityClass);
		XmlGroup group = entityClass.getAnnotation(XmlGroup.class);
		
		// Runtime error if the tableclass's type parameter does not match E
		@SuppressWarnings("unchecked")
		Class<? extends EntityTable<E>> tableClass = (Class<? extends EntityTable<E>>) group.value();
		
		return new EntityMarshaller<E>(tableClass);
	}
	
	private <T extends EntityTable<E>> EntityMarshaller(Class<T> tableClass) throws InstantiationException, IllegalAccessException {
		this.tableClass = tableClass;
		this.table = tableClass.newInstance();

		//TODO: 
		// Can all functionality be moved to this class and away from the EntityTable interface?
		// To do this, need to use the argument table class' annotations to dynamically create a 
		// new instance of a class which contains the correct add/addall/getEntities methods. Then,
		// the returned EntityMarshaller will pass the method calls through to that object instead 
		// of to the EntityTable instance. 
		// The purpose of this would be to avoid the boilerplate code in all of the EntityTable classes.	
	}

	public void add(E entity) {
		table.add(entity);
	}
	
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
