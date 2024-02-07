package it.newo.levels.dto;

import it.newo.levels.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

	private long id;
	
	@NotNull
	private Role role;
	
	@Email
	@NotBlank
	private String email;
	
	@NotNull
	private String username;
	
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_+=]).{8,}$", 
			message = "It must be longer than 8, contain at least one uppercase letter, two numbers, and one special character")
	private String password;
	
	private String name;
	
	private String surname;
	
	private long[] goalsIDs;
	
	private long[] tasksIDs;
	
	@NotNull
	private boolean active = true;
}
