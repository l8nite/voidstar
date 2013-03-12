/**
 *                               .__
 * ______      ____ ______  __ __|  |   ____      __ __  ______
 * \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
 * |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
 * |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
 * |__|    \/       |__|                      \/            \/
 *
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.p.opulo.util;

import java.lang.annotation.Annotation;

public class Assertions {
	public static void assertAnnotationPresent(Class<?> annotatedClass, Class<? extends Annotation> annotationClass) {
		if(!annotatedClass.isAnnotationPresent(annotationClass)) {
			throw new IllegalStateException("Class " + annotatedClass.getSimpleName() + " does not contain the " + annotationClass.getSimpleName() + " annotation.");
		}
	}
}
