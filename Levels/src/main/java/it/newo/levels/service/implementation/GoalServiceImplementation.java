package it.newo.levels.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.Goal;
import it.newo.levels.repository.GoalRepository;
import it.newo.levels.service.definition.GoalService;

@Service
public class GoalServiceImplementation implements GoalService{
	
	@Autowired
	private GoalRepository store;

	@Override
	public void save(Goal goal) {
		store.save(goal);
	}

	@Override
	public Goal get(long id) {
		return store.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Goal get(String title) {
		return store.findByTitle(title).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Goal> getAll() {
		return store.findAll();
	}

}
