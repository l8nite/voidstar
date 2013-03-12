package us.p.opulo.dao.service;

import java.util.List;

import us.p.opulo.dao.Country;
import us.p.opulo.dao.Language;

public interface LanguageService {
	Language getLanguageById(Integer id);
	Language getLanguageByName(String name);
	List<Language> getLanguagesByCountry(Country country);
}