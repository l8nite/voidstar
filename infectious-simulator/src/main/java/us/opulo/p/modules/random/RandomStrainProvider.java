package us.opulo.p.modules.random;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import us.opulo.p.annotations.HibernateService;
import us.opulo.p.dao.Strain;
import us.opulo.p.dao.service.StrainService;

@Singleton
public class RandomStrainProvider implements Provider<Strain>{

	List<Strain> allStrains;
	Random random;
	
	@Inject
	public RandomStrainProvider (@HibernateService StrainService strainService) {
		super();
		allStrains = strainService.getAllStrains();
		random = new Random();
	}
	
	@Override
	public Strain get() {
		return allStrains.get(random.nextInt(allStrains.size()));
	}
}
