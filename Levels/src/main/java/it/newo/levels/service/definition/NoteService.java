package it.newo.levels.service.definition;

import java.util.List;

import it.newo.levels.model.Note;

public interface NoteService {

	void save(Note note);
	Note get(long id);
	List<Note> getAll();
	void delete(long id);
}
