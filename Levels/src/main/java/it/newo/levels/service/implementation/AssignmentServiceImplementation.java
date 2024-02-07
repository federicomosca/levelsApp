package it.newo.levels.service.implementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.Assignment;
import it.newo.levels.repository.AssignmentRepository;
import it.newo.levels.service.definition.AssignmentService;

@Service
public class AssignmentServiceImplementation implements AssignmentService{
	
	private AssignmentRepository store;

	@Override
	public void save(Assignment assignment) {
		store.save(assignment);
	}

	@Override
	public Assignment get(long id) {
		return store.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Assignment> getAll() {
		return store.findAll();
	}

}
