package it.newo.levels.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDTO {
	
	private long id;

	@NotNull
	private String username;
	
	@NotNull
	private String password;
}
