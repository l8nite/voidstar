package us.opulo.p.dao.service.gwt;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.opulo.p.dao.Country;
import us.opulo.p.dao.Language;
import us.opulo.p.dao.service.LanguageService;
import us.opulo.p.guice.annotations.HibernateService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Singleton
public class LanguageServiceGwt extends RemoteServiceServlet implements LanguageService, RemoteService {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LanguageServiceGwt.class);
	
	@Inject
	@HibernateService
	LanguageService hibernateService;

	@Override
	public List<Language> getAllLanguages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language getLanguageWithId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getLanguagesWithIds(Collection<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language getLanguageWithName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getLanguagesWithNames(Collection<String> names) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getLanguagesInCountry(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> getLanguagesInCountries(Collection<Country> countries) {
		// TODO Auto-generated method stub
		return null;
	}
}