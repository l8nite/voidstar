package edu.sjsu.voidstar.project2.jaxb.tables;

import java.util.List;

import edu.sjsu.voidstar.project1.dao.HEntity;

public interface EntityTable <E extends HEntity> {
	public List<E> get();
}
