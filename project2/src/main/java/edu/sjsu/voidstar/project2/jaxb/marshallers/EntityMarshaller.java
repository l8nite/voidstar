package edu.sjsu.voidstar.project2.jaxb.marshallers;

import java.io.OutputStream;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.sjsu.voidstar.project1.dao.HEntity;
import edu.sjsu.voidstar.project2.jaxb.tables.EntityTable;

public class EntityMarshaller <T extends EntityTable<E>, E extends HEntity>{
	
	T table;
	
	public EntityMarshaller(T table) {
		this.table = table;
	}
	
	public void add(E entity) {
		table.add(entity);
	}
	
	public void addAll(Collection<E> entities) {
		table.addAll(entities);
	}
	
	public void marshal() {			
		marshal(System.out);
	}
	
	public void marshal(OutputStream out) {
		try {
			JAXBContext context = JAXBContext.newInstance(new Class[]{table.getClass()});
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(table, out);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}	
	}
}
