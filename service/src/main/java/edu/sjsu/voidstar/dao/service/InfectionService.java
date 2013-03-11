package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.City;
import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Infection;

public interface InfectionService {
	Infection getInfectionByCity(City city);

	List<Infection> getInfectionsByCountry(Country country);
}
