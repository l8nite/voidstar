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

/**
 * String manipulation methods common to the populous projects.
 * @author Jason Campos
 */
public class StringUtil {
	
	/**
	 * Joins the items of a collection together with the argument delimiter followed by a space. 
	 * Invokes the toString() method on each item in the collection. 
	 * 
	 * @param collection The collection to join
	 * @param delimiter The delimiter to place between each item in the collection.
	 * @return The concatenated string of all items in the collection joined with the argument delimiter.
	 */
	public static String joinCollection(Collection<?> collection, char delimiter) {
		return joinCollection(collection, delimiter, true);
	}
	
	/**
	 * Joins the items of a collection together with the argument delimiter optionally followed by a space. 
	 * Invokes the toString() method on each item in the collection. 
	 * 
	 * @param collection The collection to join
	 * @param delimiter The delimiter to place between each item in the collection.
	 * @param addSpace {@code true} to add a space after the delimiter. {@code false} for no space.
	 * @return The concatenated string of all items in the collection joined with the argument delimiter.
	 */
	public static String joinCollection(Collection<?> collection, char delimiter, boolean addSpace) {
		StringBuilder result = new StringBuilder();
		for(Object o : collection) {
			result.append(o.toString() + delimiter + (addSpace ? " "  : ""));
		}
		
		return result.length() > 0 ? result.substring(0, result.length() - (addSpace ? 2 : 1)) : "";
	}
}
