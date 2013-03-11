package edu.sjsu.voidstar.dao.service;

import java.util.List;

import edu.sjsu.voidstar.dao.Country;
import edu.sjsu.voidstar.dao.Language;

public interface LanguageService {
	Language getLanguageById(Integer id);
	Language getLanguageByName(String name);
	List<Language> getLanguagesByCountry(Country country);
}