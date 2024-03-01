package it.newo.levels.dto;

import lombok.Data;

@Data
public class NoteDTO {

	private long id;
	
	private String title;
	
	private String text;
	
	private long taskId;
	
	private long goalId;
}
