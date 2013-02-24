package edu.sjsu.voidstar.project2.jaxb.marshallers;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

public class EntityUnmarshaller <T extends EntityTable<?>> {
	
	JAXBContext context;
	Unmarshaller unmarshaller;
	
	public EntityUnmarshaller(Class<T> entityTableClass) {	
		try {
			this.context = JAXBContext.newInstance( new Class[] { entityTableClass } );
			this.unmarshaller = context.createUnmarshaller();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public T unmarshall(InputStream is) throws JAXBException {
		return (T) unmarshaller.unmarshal(is);
	}
}
