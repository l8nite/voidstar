package edu.sjsu.voidstar.project2.jaxb.assertions;

import edu.sjsu.voidstar.project2.jaxb.annotations.XmlGroup;
import edu.sjsu.voidstar.project2.util.Assertions;

public class JAXBAssertions {
	public static void assertXmlGroupAnnotationIsPresent(Class<?> entityClass){
		Assertions.assertAnnotationPresent(entityClass,XmlGroup.class);
	}
}
