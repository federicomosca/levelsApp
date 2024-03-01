package it.newo.levels.facade.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.dto.GoalDTO;
import it.newo.levels.facade.definition.GoalFacade;
import it.newo.levels.mapper.GoalMapper;
import it.newo.levels.model.Goal;
import it.newo.levels.service.definition.GoalService;

@Service
public class GoalFacadeImplementation implements GoalFacade {
	
	@Autowired
	private GoalService goalService;
	
	@Autowired
	private GoalMapper goalMapper;

	@Override
	public void save(GoalDTO goal) {
		goalService.save(goalMapper.fromDTO(goal));
	}

	@Override
	public Goal select(long id) {
		Goal g = goalService.get(id);
		return g;
	}

	@Override
	public List<Goal> selectAll() {
		List<Goal> goals = goalService.getAll();
		return goals;
	}

	@Override
	public void delete(long id) {
		goalService.delete(id);
	}

	@Override
	public void toggleArchivedStatus(long id) {
		Goal g = goalService.get(id);
		if (g!=null) { 
			if (g.isArchived()) g.setArchived(false); else g.setArchived(true);
			goalService.save(g);
		} else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

}
