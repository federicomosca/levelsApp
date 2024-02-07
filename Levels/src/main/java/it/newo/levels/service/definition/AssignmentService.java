package it.newo.levels.service.definition;

import java.util.List;

import it.newo.levels.model.Assignment;

public interface AssignmentService {

	void save(Assignment assignment);
	Assignment get(long id);
	List<Assignment> getAll();
}
