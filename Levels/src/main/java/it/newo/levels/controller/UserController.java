package it.newo.levels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.newo.levels.dto.UserDTO;
import it.newo.levels.facade.definition.UserFacade;

@RestController
public class UserController {
	
	@Autowired
	private UserFacade facade;

	@PostMapping("super_admin/user/create_admin")
	private ResponseEntity<Void> createAdmin(@RequestParam UserDTO admin) {
		facade.createAdmin(admin);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("super_admin/user/toggle_user_activity_status")
	private ResponseEntity<Void> toggleUserActivityStatus(@RequestParam long userID){
		facade.toggleUserActivityStatus(userID);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	private ResponseEntity<List<UserDTO>> getAll(){
		return ResponseEntity.ok(facade.getAll());
	}
	
	@PostMapping
	private ResponseEntity<Void> signUp(@RequestParam UserDTO user){
		facade.signUp(user);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	private ResponseEntity<String> signIn(@RequestParam UserDTO user){
		facade.signIn(user);
		return ResponseEntity.ok("Successfully logged in");
	}
	
	@PutMapping
	private ResponseEntity<String> unsubscribe(@RequestParam UserDTO user){
		facade.unsubscribe(user);
		return ResponseEntity.ok("Successfully unsubscribed");
	}
	
}
