package edu.sjsu.voidstar.project2.jaxb.generators;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import edu.sjsu.voidstar.constants.Constants.Files.XSD;


public class XsdGenerator {

	private XsdGenerator() {} 
	
	public static void generateSchema(Class<?> entityClass) throws JAXBException, IOException {
		JAXBContext
			.newInstance(entityClass)
			.generateSchema(new EntitySchemaOutputResolver(entityClass));
	}
	
	private static class EntitySchemaOutputResolver extends SchemaOutputResolver {
		public Class<?> entityClass;
		
		public EntitySchemaOutputResolver (Class<?> entityClass) {
			this.entityClass = entityClass;
		}
		
		public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
	        File file = new File(XSD.PATH + "/" + entityClass.getSimpleName() + ".xsd");
	        StreamResult result = new StreamResult(file);
	        result.setSystemId(file.toURI().toURL().toString());
	        System.out.println(file.toURI().toURL().toString());
	        return result;
	    }
	}
}
