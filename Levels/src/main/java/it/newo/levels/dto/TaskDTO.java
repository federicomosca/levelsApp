package it.newo.levels.dto;

import lombok.Data;

@Data
public class TaskDTO {

	private long id;
	
	private String title;
	
	private String description;
	
	private long[] assignmentsIDs;
	
	private long[] notesIDs;
}
