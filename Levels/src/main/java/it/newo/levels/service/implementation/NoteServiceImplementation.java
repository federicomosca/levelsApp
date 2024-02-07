package it.newo.levels.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.Note;
import it.newo.levels.repository.NoteRepository;
import it.newo.levels.service.definition.NoteService;

@Service
public class NoteServiceImplementation implements NoteService{

	@Autowired
	private NoteRepository store;

	@Override
	public void save(Note note) {
		store.save(note);
	}

	@Override
	public Note get(long id) {
		return store.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Note> getAll() {
		return store.findAll();
	}
}
