package edu.sjsu.voidstar.project2.jaxb.generators;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.sjsu.voidstar.constants.Constants.Files.XSD;

/**
 * This class creates an XSD for any JAXB annotated class. The sole method, {@link #generateSchema(Class)}, accepts as an 
 * argument the class for which to generate the XSD.
 * 
 * @author Jason Campos
 */
public class XsdGenerator {
	private static final Logger log = LoggerFactory.getLogger(XsdGenerator.class);
	
	// Prevent construction
	private XsdGenerator() {} 
	
	public static void generateSchema(Class<?> entityClass) throws JAXBException, IOException {
		JAXBContext
			.newInstance(entityClass)
			.generateSchema(new EntitySchemaOutputResolver(entityClass));
	}
	
	/*
	 * (non-Javadoc)
	 * Writes XSD output to the XSD directory specified in Constants.java 
	 */
	private static class EntitySchemaOutputResolver extends SchemaOutputResolver {
		public Class<?> entityClass;
		
		public EntitySchemaOutputResolver (Class<?> entityClass) {
			this.entityClass = entityClass;
		}
		
		public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException {
	        File file = new File(XSD.PATH + "/" + entityClass.getSimpleName() + ".xsd");
	        StreamResult result = new StreamResult(file);
	        result.setSystemId(file.toURI().toURL().toString());
	        log.info("Created XSD: " + file.toURI().toURL().toString());
	        return result;
	    }
	}
}