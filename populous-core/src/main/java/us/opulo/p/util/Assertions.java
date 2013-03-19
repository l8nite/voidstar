/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.util;

import java.lang.annotation.Annotation;

/**
 * Assertions commonly used in the populous project.
 * @author Jason Campos
 */
public class Assertions {
	
	/**
	 * Asserts that the argument annotatedClass contains the argument annotationClass.
	 * @param annotatedClass The class which is expected to be annotated
	 * @param annotationClass The annotation expected to be present.
	 */
	public static void assertAnnotationPresent(Class<?> annotatedClass, Class<? extends Annotation> annotationClass) {
		if(!annotatedClass.isAnnotationPresent(annotationClass)) {
			throw new AssertionError("Class " + annotatedClass.getSimpleName() + " does not contain the " + annotationClass.getSimpleName() + " annotation.");
		}
	}
}
