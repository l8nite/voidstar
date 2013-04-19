package us.opulo.p.simulator.modules.random;

import java.util.Random;
import java.util.UUID;

import javax.inject.Provider;

import com.google.inject.Singleton;

import us.opulo.p.dao.InfectionEventDetail;

@Singleton
public class RandomEventDetailProvider implements Provider<InfectionEventDetail> {
	// TODO: move these into random strainprovider, mutationprovider, vectorprovider etc..
	private final String[] strains = { "Alpha Zero", "Beta One", "Cappa Two" };
	private final String[] mutations = { "M1", "M2", "M3", "M4", "M5" };
	private final String[] vectors = { "Airborne", "Contact", "Water" };
	private final String epidemicName;
	
	public RandomEventDetailProvider () {
		this.epidemicName = UUID.randomUUID().toString();
	}

	@Override
	public InfectionEventDetail get() {
		Random rand = new Random();
		return new InfectionEventDetail(epidemicName, strains[rand.nextInt(strains.length)], mutations[rand.nextInt(mutations.length)], vectors[rand.nextInt(vectors.length)]);
	}

}
