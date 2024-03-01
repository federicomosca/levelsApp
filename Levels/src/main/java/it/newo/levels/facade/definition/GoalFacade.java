package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.GoalDTO;
import it.newo.levels.model.Goal;

public interface GoalFacade {
	
	void save(GoalDTO goal);
	Goal select(long id);
	List<Goal> selectAll();
	void delete(long id);
	void archive(long id);
}
