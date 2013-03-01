package edu.sjsu.voidstar.jaxb.assertions;

import edu.sjsu.voidstar.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.util.Assertions;

public class JAXBAssertions {
	public static void assertXmlGroupAnnotationIsPresent(Class<?> entityClass){
		Assertions.assertAnnotationPresent(entityClass,XmlGroup.class);
	}
}
