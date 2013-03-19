/**
 * This file is a component of the p.opulo.us project.
 *
 * Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
 * All Rights Reserved.
 *
 * This software is licensed under The MIT License (MIT)
 * http://opensource.org/licenses/MIT
 */
package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.util.StringUtil;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class LanguageServiceGwt extends RemoteServiceServlet implements LanguageService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LanguageServiceGwt.class);
	
	@Inject
	@HibernateService
	LanguageService hibernateService;

	@Override
	public List<Language> getAllLanguages() {
		log.info("getAllLanguages()");
		return hibernateService.getAllLanguages();
	}

	@Override
	public Language getLanguageWithId(Integer id) {
		log.info("getLanguageWithId(): id = " + id);
		return hibernateService.getLanguageWithId(id);
	}

	@Override
	public List<Language> getLanguagesWithIds(Collection<Integer> ids) {
		log.info("getLanguagesWithIds(): ids = " + StringUtil.joinCollection(ids, ','));
		return hibernateService.getLanguagesWithIds(ids);
	}

	@Override
	public Language getLanguageWithName(String name) {
		log.info("getLanguageWithName(): name = " + name);
		return hibernateService.getLanguageWithName(name);
	}

	@Override
	public List<Language> getLanguagesWithNames(Collection<String> names) {
		log.info("getLanguagesWithNames(): names = " + StringUtil.joinCollection(names, ','));
		return hibernateService.getLanguagesWithNames(names);
	}

	@Override
	public List<Language> getLanguagesInCountry(Country country) {
		log.info("getLanguagesInCountry(): country = " + country);
		return hibernateService.getLanguagesInCountry(country);
	}

	@Override
	public List<Language> getLanguagesInCountries(Collection<Country> countries) {
		log.info("getLanguagesInCountries(): countries = " + StringUtil.joinCollection(countries, ','));
		return hibernateService.getLanguagesInCountries(countries);
	}
}