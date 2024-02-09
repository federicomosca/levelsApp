package it.newo.levels.dto;

import it.newo.levels.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
	
	private Role role = Role.USER;
	
	@NotBlank
	private String email;
	
	@NotNull
	private String username;
	
	private String password;
	
	private String name;
	
	private String surname;
	
	private long[] goalsIDs;
	
	private long[] tasksIDs;
	
	private boolean active = true;
}
