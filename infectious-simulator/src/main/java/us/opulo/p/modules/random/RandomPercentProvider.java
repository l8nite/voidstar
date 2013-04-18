package us.opulo.p.modules.random;

import java.util.Random;

import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Returns a random Double
 * @author Jason Campos
 */
@Singleton
public class RandomPercentProvider implements Provider<Double> {

	Random random;
	
	public RandomPercentProvider () {
		super();
		random = new Random();
	}
	
	@Override
	public Double get() {
		return random.nextDouble();
	}
}
