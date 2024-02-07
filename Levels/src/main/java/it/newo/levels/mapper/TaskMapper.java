package it.newo.levels.mapper;

import org.springframework.stereotype.Component;

import it.newo.levels.dto.TaskDTO;
import it.newo.levels.model.Task;

@Component
public class TaskMapper {

	public Task fromDTO(TaskDTO dto) {
		Task t = new Task();
		
		t.setTitle(dto.getTitle());
		t.setDescription(dto.getDescription());
		
		return t;
	}
}
