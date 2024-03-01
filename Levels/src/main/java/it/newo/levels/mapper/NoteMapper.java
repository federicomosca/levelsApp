package it.newo.levels.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.newo.levels.dto.NoteDTO;
import it.newo.levels.model.Goal;
import it.newo.levels.model.Note;
import it.newo.levels.model.Task;
import it.newo.levels.service.definition.GoalService;
import it.newo.levels.service.definition.TaskService;

@Component
public class NoteMapper {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private GoalService goalService;

	public Note fromDTO(NoteDTO dto) {
		
		Note n = new Note();
		Task t = new Task();
		Goal g = new Goal();
		
		n.setTitle(dto.getTitle());
		n.setText(dto.getText());
		if(dto.getTaskId()>=0) {
			t = taskService.get(dto.getTaskId());
			n.setTask(t);
		}
		
		if(dto.getGoalId()>=0) {
			g = goalService.get(dto.getGoalId());
			n.setGoal(g);
		}
		
		return n;
	}
	
	public NoteDTO toDTO(Note n) {
		
		NoteDTO dto = new NoteDTO();
		
		dto.setTitle(n.getTitle());
		dto.setText(n.getText());
		dto.setTaskId(n.getTask().getId());
		dto.setGoalId(n.getGoal().getId());
		
		return dto;
	}
}
