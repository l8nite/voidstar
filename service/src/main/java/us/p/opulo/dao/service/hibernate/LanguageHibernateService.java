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
package us.p.opulo.dao.service.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.hibernate.criterion.Restrictions;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;
import us.p.opulo.dao.service.CountryLanguageService;
import us.p.opulo.dao.service.LanguageService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class LanguageHibernateService implements LanguageService {
	@Inject
	@HibernateService
	private CountryLanguageService countryLanguageService;

	@Override
	public Language getLanguageById(Integer languageId) {
		return (Language) HibernateSession.get()
				.createCriteria(Language.class)
				.add(Restrictions.eq("id", languageId))
				.uniqueResult();
	}

	@Override
	public Language getLanguageByName(String languageName) {
		return (Language) HibernateSession.get()
				.createCriteria(Language.class)
				.add(Restrictions.eq("language", languageName))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguagesByCountry(Country country) {
		return HibernateSession.get().createCriteria(Language.class, "l")
				.createAlias("countries", "cl")
				.add(Restrictions.eq("cl.countryCode", country.getCode()))
				.list();
	}
}
