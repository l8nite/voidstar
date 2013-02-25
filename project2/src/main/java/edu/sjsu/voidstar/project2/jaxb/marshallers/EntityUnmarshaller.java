package edu.sjsu.voidstar.project2.jaxb.marshallers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

/**
 * Class responsible for unmarshalling XML from EntityTable XML.
 * 
 * @author Jason Campos
 * @param <T> The EntityTable class being unmarshalled.
 */
public class EntityUnmarshaller <T extends EntityTable<?>> {
	private static final Logger log = LoggerFactory.getLogger(EntityUnmarshaller.class);
	
	private JAXBContext context;
	private Unmarshaller unmarshaller;
	
	public EntityUnmarshaller(Class<T> entityTableClass) {	
		try {
			this.context = JAXBContext.newInstance( new Class[] { entityTableClass } );
			this.unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	public T unmarshall(File file) throws FileNotFoundException, JAXBException {
		return unmarshall(new FileInputStream(file));
	}
	
	@SuppressWarnings("unchecked")
	public T unmarshall(InputStream is) throws JAXBException {
		return (T) unmarshaller.unmarshal(is);
	}
}
