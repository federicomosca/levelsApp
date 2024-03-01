package it.newo.levels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.newo.levels.dto.GoalDTO;
import it.newo.levels.facade.definition.GoalFacade;
import it.newo.levels.model.Goal;

@RestController
@RequestMapping("goal")
public class GoalController {
	
	@Autowired
	private GoalFacade facade;
	
	@PostMapping("create")
	private ResponseEntity<Void> create(GoalDTO goal){
		facade.save(goal);
		return ResponseEntity.ok().build();
	}
	
	//got to fix this
	
	@PutMapping("update")
	private ResponseEntity<Void> update(GoalDTO goal){
		facade.save(goal);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("select")
	private ResponseEntity<Goal> select(long id) {
		return ResponseEntity.ok(facade.select(id));
	}
	
	@GetMapping("select_all")
	private ResponseEntity<List<Goal>> selectAll(){
		return ResponseEntity.ok(facade.selectAll());
	}
	
	@DeleteMapping("delete")
	private ResponseEntity<String> delete(long id){
		facade.delete(id);
		return ResponseEntity.ok("goal with id " + id + " has been deleted");
	}
	
	@PutMapping("toggle_archive")
	private ResponseEntity<String> toggleArchivedStatus(long id){
		facade.toggleArchivedStatus(id);
		Goal g = facade.select(id);
		String status = g.isArchived() ? "archived" : "unarchived";
		return ResponseEntity.ok("goal with id " + id + status);
	}

}
