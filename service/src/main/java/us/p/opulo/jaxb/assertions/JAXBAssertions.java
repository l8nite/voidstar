package us.p.opulo.jaxb.assertions;

import us.p.opulo.jaxb.annotations.XmlGroup;
import us.p.opulo.util.Assertions;

public class JAXBAssertions {
	public static void assertXmlGroupAnnotationIsPresent(Class<?> entityClass){
		Assertions.assertAnnotationPresent(entityClass,XmlGroup.class);
	}
}
