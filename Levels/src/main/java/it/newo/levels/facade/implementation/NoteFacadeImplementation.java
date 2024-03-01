package it.newo.levels.facade.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.newo.levels.dto.NoteDTO;
import it.newo.levels.facade.definition.NoteFacade;
import it.newo.levels.mapper.NoteMapper;
import it.newo.levels.model.Note;
import it.newo.levels.service.definition.NoteService;

@Service
public class NoteFacadeImplementation implements NoteFacade {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private NoteMapper noteMapper;

	@Override
	public void save(NoteDTO note) {
		noteService.save(noteMapper.fromDTO(note));
	}

	@Override
	public Note select(long id) {
		return noteService.get(id);
	}

	@Override
	public List<Note> selectAll() {
		return noteService.getAll();
	}

	@Override
	public void delete(long id) {
		noteService.delete(id);
	}

}
