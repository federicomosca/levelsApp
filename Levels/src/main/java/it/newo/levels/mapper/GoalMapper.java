package it.newo.levels.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.newo.levels.dto.GoalDTO;
import it.newo.levels.model.Assignment;
import it.newo.levels.model.Goal;
import it.newo.levels.model.Note;
import it.newo.levels.service.definition.AssignmentService;
import it.newo.levels.service.definition.NoteService;

@Component
public class GoalMapper {
	
	private AssignmentService assignmentService;
	
	private NoteService noteService;

	public Goal fromDTO(GoalDTO dto) {
		Goal g = new Goal();
		g.setTitle(dto.getTitle());
		g.setDescription(dto.getDescription());
		g.setPriority(dto.getPriority());
		g.setComplexity(dto.getComplexity());
		g.setProgress(dto.getProgress());
		
		long[] assignmentsIDs = dto.getAssignmentsIDs();
		List<Assignment> assignments = new ArrayList<Assignment>();
		if(assignmentsIDs != null) {
			for (long assignmentID : assignmentsIDs) {
				Assignment a = assignmentService.get(assignmentID);
				assignments.add(a);
			}
			g.setAssignments(assignments);			
		}
		
		long[] notesIDs = dto.getNotesIDs();
		List<Note> notes = new ArrayList<Note>();
		if(notesIDs != null) {
			for(long noteID : notesIDs) {
				Note n = noteService.get(noteID);
				notes.add(n);
			}			
			g.setNotes(notes);
		}
		
		return g;
	}
	
	public GoalDTO toDTO(Goal g) {
		GoalDTO dto = new GoalDTO();
		
		dto.setTitle(g.getTitle());
		dto.setDescription(g.getDescription());
		dto.setPriority(g.getPriority());
		dto.setComplexity(g.getComplexity());
		dto.setProgress(g.getProgress());
	
		long[] assignmentsIDs = g.getAssignments().stream()
				.map(Assignment::getId)
				.mapToLong(Long::valueOf)
				.toArray();
		dto.setAssignmentsIDs(assignmentsIDs);
		
		long[] notesIDs = g.getNotes().stream()
				.map(Note::getId)
				.mapToLong(Long::valueOf)
				.toArray();
		dto.setNotesIDs(notesIDs);
		
		return dto;
	}
}
