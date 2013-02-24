package edu.sjsu.voidstar.project2.jaxb.tables;

import java.util.Collection;
import java.util.List;

import edu.sjsu.voidstar.project1.dao.HEntity;

public interface EntityTable <E extends HEntity>{
	public void add(E entity);
	public void addAll(Collection<E> entities);
	public List<E> getEntities();
}
