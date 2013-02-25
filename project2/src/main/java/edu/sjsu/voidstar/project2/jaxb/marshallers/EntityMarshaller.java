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
import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

/**
 * Class responsible for marshalling EntityTable/HEntity objects to XML.
 * 
 * @author Jason Campos
 * @param <T> The EntityTable wrapper responsible for marshalling the Entity
 * @param <E> The Entity being marshalled
 */
public class EntityMarshaller <T extends EntityTable<E>, E extends HEntity>{
	private static final Logger log = LoggerFactory.getLogger(EntityMarshaller.class);
	
	// The EntityTable object holding the collection of Entities to marshal.
	private T table;
	
	public EntityMarshaller(T table) {
		this.table = table;
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
			JAXBContext context = JAXBContext.newInstance(new Class[]{table.getClass()});
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			// If the class has the SchemaLocation annotation, set the schema location
			if(table.getClass().isAnnotationPresent(SchemaLocation.class)) {
				SchemaLocation location = table.getClass().getAnnotation(SchemaLocation.class);
				marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, location.value());
			}
			
			marshaller.marshal(table, out);
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}	
	}
}
