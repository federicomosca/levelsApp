package it.newo.levels.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.Task;
import it.newo.levels.repository.TaskRepository;
import it.newo.levels.service.definition.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {
	
	@Autowired
	private TaskRepository store;

	@Override
	public void save(Task task) {
		store.save(task);
	}

	@Override
	public Task get(long id) {
		return store.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Task> getAll() {
		return store.findAll();
	}

	@Override
	public void delete(long id) {
		store.deleteById(id);
	}

}
