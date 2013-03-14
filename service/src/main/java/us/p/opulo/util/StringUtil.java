package us.p.opulo.util;

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
