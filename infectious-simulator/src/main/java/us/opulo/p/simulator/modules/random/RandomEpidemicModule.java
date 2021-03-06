package us.opulo.p.simulator.modules.random;

import java.util.Date;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.City;
import us.opulo.p.dao.InfectionEventDetail;
import us.opulo.p.dao.service.CityService;
import us.opulo.p.dao.service.InfectionService;
import us.opulo.p.dao.service.hibernate.CityServiceHibernate;
import us.opulo.p.dao.service.hibernate.InfectionServiceHibernate;

import com.google.inject.AbstractModule;

/**
 * A module configured to return randomized everything.
 * 
 * @author Jason Campos
 */
public class RandomEpidemicModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(InfectionService.class)
			.annotatedWith(HibernateService.class)
			.to(InfectionServiceHibernate.class);
	
		bind(CityService.class)
			.annotatedWith(HibernateService.class)
			.to(CityServiceHibernate.class);
	
		bind(City.class)
			.toProvider(RandomCityProvider.class);
		
		bind(Date.class)
			.toProvider(IncrementalDateProvider.class);
		
		bind(Double.class)
			.toProvider(RandomPercentProvider.class);
		
		bind(InfectionEventDetail.class)
			.toProvider(RandomEventDetailProvider.class);
	}
}
