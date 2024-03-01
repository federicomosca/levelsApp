package it.newo.levels.facade.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.dto.TaskDTO;
import it.newo.levels.facade.definition.TaskFacade;
import it.newo.levels.mapper.TaskMapper;
import it.newo.levels.model.Task;
import it.newo.levels.service.definition.TaskService;

@Service
public class TaskFacadeImplementation implements TaskFacade {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public void save(TaskDTO task) {
		taskService.save(taskMapper.fromDTO(task));
	}

	@Override
	public Task select(long id) {
		return taskService.get(id);
	}

	@Override
	public List<Task> selectAll() {
		return taskService.getAll();
	}

	@Override
	public void delete(long id) {
		taskService.delete(id);
	}

	@Override
	public void toggleDoneStatus(long id) {
		Task t = taskService.get(id);
		if(t!=null) {
			if(t.isDone()) t.setDone(false); else t.setDone(true);
			taskService.save(t);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
