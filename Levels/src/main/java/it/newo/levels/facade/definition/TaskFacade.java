package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.TaskDTO;
import it.newo.levels.model.Task;

public interface TaskFacade {

	void save(TaskDTO task);
	Task select(long id);
	List<Task> selectAll();
	void delete(long id);
	void toggleDoneStatus(long id);
}
