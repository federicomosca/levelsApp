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

import it.newo.levels.dto.TaskDTO;
import it.newo.levels.facade.definition.TaskFacade;
import it.newo.levels.model.Task;

@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	private TaskFacade facade;
	
	@PostMapping("create")
	private ResponseEntity<Void> create(TaskDTO Task){
		facade.save(Task);
		return ResponseEntity.ok().build();
	}
	
	//got to fix this
	
	@PutMapping("update")
	private ResponseEntity<Void> update(TaskDTO Task){
		facade.save(Task);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("select")
	private ResponseEntity<Task> select(long id) {
		return ResponseEntity.ok(facade.select(id));
	}
	
	@GetMapping("select_all")
	private ResponseEntity<List<Task>> selectAll(){
		return ResponseEntity.ok(facade.selectAll());
	}
	
	@DeleteMapping("delete")
	private ResponseEntity<String> delete(long id){
		facade.delete(id);
		return ResponseEntity.ok("Task with id " + id + " has been deleted");
	}
	
	@PutMapping("toggle_archive")
	private ResponseEntity<String> toggleArchivedStatus(long id){
		facade.toggleDoneStatus(id);
		Task t = facade.select(id);
		String status = t.isDone() ? "done" : "undone";
		return ResponseEntity.ok("Task with id " + id + status);
	}
}
