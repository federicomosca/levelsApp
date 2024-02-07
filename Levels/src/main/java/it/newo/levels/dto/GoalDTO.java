package it.newo.levels.dto;

import it.newo.levels.model.enums.Complexity;
import it.newo.levels.model.enums.Priority;
import it.newo.levels.model.enums.Progress;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoalDTO {
	
	private long id;
	
	@NotNull
	private String title;
	
	private String description;
	
	@NotNull
	private Priority priority;
	
	@NotNull
	private Complexity complexity;
	
	@NotNull
	private Progress progress;
	
	private long[] assignmentsIDs;
	
	private long[] notesIDs;
}
