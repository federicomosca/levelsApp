 package it.newo.levels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.newo.levels.dto.LoginDTO;
import it.newo.levels.dto.UserDTO;
import it.newo.levels.facade.definition.UserFacade;
import it.newo.levels.model.User;
import jakarta.validation.Valid;

@RestController("/user")
public class UserController {
	
	@Autowired
	private UserFacade facade;

	@PostMapping("user/create_admin")
	private ResponseEntity<Void> createAdmin(@RequestBody UserDTO admin) {
		facade.createAdmin(admin);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("user/toggle_user_activity_status")
	private ResponseEntity<String> toggleUserActivityStatus(@RequestParam long userID){
		facade.toggleUserActivityStatus(userID);
		return ResponseEntity.ok("user activity status changed");
	}
	
	@GetMapping("user/get_all")
	private ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(facade.getAll());
	}
	
	@PostMapping("user/sign_up")
	private ResponseEntity<Void> signUp(@RequestBody UserDTO user){
		facade.signUp(user);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("user/sign_in")
	private ResponseEntity<String> signIn(@RequestBody LoginDTO user){
		facade.signIn(user);
		return ResponseEntity.ok("Successfully logged in");
	}
	
	@PutMapping("user/unsubscribe")
	private ResponseEntity<String> unsubscribe(@RequestBody LoginDTO user){
		facade.unsubscribe(user);
		return ResponseEntity.ok("Successfully unsubscribed");
	}
	
}
