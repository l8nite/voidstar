package us.opulo.p.modules.random;

import java.util.Random;

import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Returns a random integer
 * @author Jason Campos
 */
@Singleton
public class RandomIntegerProvider implements Provider<Integer> {

	Random random;
	
	public RandomIntegerProvider () {
		super();
		random = new Random();
	}
	
	@Override
	public Integer get() {
		return random.nextInt();
	}
}
