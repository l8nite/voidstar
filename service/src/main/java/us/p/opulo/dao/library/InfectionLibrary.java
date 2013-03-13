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

import com.google.inject.Singleton;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;
import us.p.opulo.dao.service.InfectionService;
import us.p.opulo.guice.annotations.HibernateService;
import us.p.opulo.hibernate.HibernateSession;

@Singleton
public class InfectionLibrary implements InfectionService {
	
	@Inject
	@HibernateService
	private InfectionService service;
	
	@Inject
	private HibernateSession session;

	@Override
	public Infection getInfectionByCity(City city) {
		return service.getInfectionByCity(city);
	}

	@Override
	public List<Infection> getInfectionsByCountry(Country country) {
		return service.getInfectionsByCountry(country);
	}
	
	/* ADDITIONAL LIBRARY METHODS */
}
