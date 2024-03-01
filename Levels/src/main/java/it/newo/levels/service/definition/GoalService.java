package it.newo.levels.service.definition;

import java.util.List;

import it.newo.levels.model.Goal;

public interface GoalService {

	void save(Goal goal);
	Goal get(long id);
	Goal get(String title);
	List<Goal> getAll();
	void delete(long id);
}
