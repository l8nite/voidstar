package us.opulo.p.dao.service.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import us.opulo.p.dao.Strain;
import us.opulo.p.dao.service.StrainService;
import us.opulo.p.hibernate.SessionProvider;

@Singleton
public class StrainServiceHibernate implements StrainService {
	
	@Inject
	private SessionProvider session;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Strain> getAllStrains() {
		return session.get().createCriteria(Strain.class).list();
	}

	@Override
	public List<Strain> getDescendentStrains(Strain strain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Strain> getChildStrains(Strain strain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Strain> getAncestorStrains(Strain strain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Strain> getParentStrains(Strain strain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Strain getStrainById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Strain getStrainByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
