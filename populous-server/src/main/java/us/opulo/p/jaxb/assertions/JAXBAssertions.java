/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.jaxb.assertions;

import us.opulo.p.jaxb.annotations.XmlGroup;
import us.opulo.p.util.Assertions;

public class JAXBAssertions {
	public static void assertXmlGroupAnnotationIsPresent(Class<?> entityClass){
		Assertions.assertAnnotationPresent(entityClass,XmlGroup.class);
	}
}
