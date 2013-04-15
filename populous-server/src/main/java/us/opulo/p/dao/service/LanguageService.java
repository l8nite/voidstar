/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service;

import java.util.Collection;
import java.util.List;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * A service interface for the Language table. Implementing classes serve the requested object(s) 
 * in a means consistent with the interface. For example, XServiceSoap would service requests 
 * on the SOAP protocol.
 * 
 * @author Jason Campos
 */
public interface LanguageService extends RemoteService {
	/**
	 * @return All Languages.
	 */
	List<Language> getAllLanguages();
	
	/**
	 * Retrieves the Language associated with the argument ID.
	 * @param id The ID of the Language to retrieve.
	 * @return The Langage associated with the argument ID.
	 */
	Language getLanguageWithId(Integer id);
	
	/**
	 * Retrieves the Languages associated with the argument IDs.
	 * @param ids The IDs of the Languages to retrieve.
	 * @return The Languages associated with the argument IDs.
	 */
	List<Language> getLanguagesWithIds(Collection<Integer> ids);
	
	/**
	 * Retrieves the Languages with the argument name.
	 * @param name The name of the Language to retrieve.
	 * @return The Language with the argument name.
	 */
	Language getLanguageWithName(String name);
	
	/**
	 * Retrieves the Languages with the argument names.
	 * @param names The names of the Languages to retrieve.
	 * @return The Languages with the argument names.
	 */
	List<Language> getLanguagesWithNames(Collection<String> names);
	
	/**
	 * Retrieves the Languages spoken in the argument country.
	 * @param country The country for which to retrieve all Languages.
	 * @return The Languages spoken in the argument country.
	 */
	List<Language> getLanguagesInCountry(Country country);
	
	/**
	 * Retrieves the Languages spoken in the argument countries
	 * @param countries The countries for which to retrieve all Languages.
	 * @return The Languages sopken in the argument countries.
	 */
	List<Language> getLanguagesInCountries(Collection<Country> countries);
}