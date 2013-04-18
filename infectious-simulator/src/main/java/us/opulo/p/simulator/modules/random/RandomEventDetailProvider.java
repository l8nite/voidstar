package us.opulo.p.simulator.modules.random;

import java.util.Random;
import java.util.UUID;

import javax.inject.Provider;

import us.opulo.p.dao.InfectionEventDetail;

public class RandomEventDetailProvider implements Provider<InfectionEventDetail> {

	// TODO: move these into random strainprovider, mutationprovider, vectorprovider etc..
	private final String[] strains = { "Alpha Zero", "Beta One", "Cappa Two" };
	private final String[] mutations = { "M1", "M2", "M3", "M4", "M5" };
	private final String[] vectors = { "Airborne", "Contact", "Water" };

	@Override
	public InfectionEventDetail get() {
		Random rand = new Random();
		return new InfectionEventDetail(UUID.randomUUID().toString(), strains[rand.nextInt(strains.length)], mutations[rand.nextInt(mutations.length)], vectors[rand.nextInt(vectors.length)]);
	}

}
