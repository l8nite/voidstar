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

import java.util.Collection;

public class StringUtil {
	
	public static String joinCollection(Collection<?> collection, char delimiter) {
		return joinCollection(collection, delimiter, true);
	}
	
	public static String joinCollection(Collection<?> collection, char delimiter, boolean addSpace) {
		StringBuilder result = new StringBuilder();
		for(Object o : collection) {
			result.append(o.toString() + delimiter + (addSpace ? " "  : ""));
		}
		
		return result.length() > 0 ? result.substring(0, result.length() - (addSpace ? 2 : 1)) : "";
	}
}
