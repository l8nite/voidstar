package us.p.opulo.dao.service;

import java.util.List;

import us.p.opulo.dao.City;
import us.p.opulo.dao.Country;
import us.p.opulo.dao.Infection;

public interface InfectionService {
	Infection getInfectionByCity(City city);
	List<Infection> getInfectionsByCountry(Country country);
}
