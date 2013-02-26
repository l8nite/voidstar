package edu.sjsu.voidstart.project2.util;

import java.lang.annotation.Annotation;

public class Assertions {
	public static void assertAnnotationPresent(Class<?> annotatedClass, Class<? extends Annotation> annotationClass) {
		if(!annotatedClass.isAnnotationPresent(annotationClass)) {
			throw new IllegalStateException("Class " + annotatedClass.getSimpleName() + " does not contain the " + annotationClass.getSimpleName() + " annotation.");
		}
	}
}
