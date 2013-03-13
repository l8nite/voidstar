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
package us.p.opulo.dao.library;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class LanguageLibrary implements LanguageService {

	@Inject 
	@HibernateService
	private LanguageService service;
	
	@Inject 
	private HibernateSession session;

	@Override
	public Language getLanguageById(Integer id) {
		return service.getLanguageById(id);
	}

	@Override
	public Language getLanguageByName(String name) {
		return service.getLanguageByName(name);
	}

	@Override
	public List<Language> getLanguagesByCountry(Country country) {
		return service.getLanguagesByCountry(country);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
