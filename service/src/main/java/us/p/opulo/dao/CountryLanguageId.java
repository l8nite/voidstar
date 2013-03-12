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
package us.p.opulo.dao;

import java.io.Serializable;

public class CountryLanguageId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String countryCode;
	private Integer languageId;

	public int hashCode() {
		return countryCode.hashCode() + languageId.hashCode();
	}

	public boolean equals(Object object) {
		if (countryCode == null || languageId == null || object == null) { 
			return false;
		}
		
		if (object instanceof CountryLanguageId) {
			CountryLanguageId otherId = (CountryLanguageId) object;
			
			if (otherId.countryCode == null || otherId.languageId == null) {
				return false;
			}
			
			return (otherId.countryCode == this.countryCode && otherId.languageId == this.languageId);
		}
		return false;
	}
}
