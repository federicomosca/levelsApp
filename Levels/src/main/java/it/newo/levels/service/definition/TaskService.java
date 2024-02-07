package it.newo.levels.service.definition;

import java.util.List;

import it.newo.levels.model.Task;

public interface TaskService {

	void save(Task task);
	Task get(long id);
	List<Task> getAll();
}
