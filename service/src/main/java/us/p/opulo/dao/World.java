package us.p.opulo.dao;

public class World {

	public static long getPopulation() {
		long worldPopulation = 0;
		for(City city: City.getCities()) {
			worldPopulation += city.getPopulation();
		}
		return worldPopulation;
	}
}
