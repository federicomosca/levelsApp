package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.NoteDTO;
import it.newo.levels.model.Note;

public interface NoteFacade {

	void save(NoteDTO note);
	Note select(long id);
	List<Note> selectAll();
	void delete(long id);
}
