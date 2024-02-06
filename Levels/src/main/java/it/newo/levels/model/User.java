package it.newo.levels.model;

import java.util.List;

import it.newo.levels.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private Role role;
	
	@OneToMany(mappedBy = "user")
	private List<UsersGoals> goals;
	
	@OneToMany(mappedBy = "user")
	private List<UsersTasks> tasks;
	
	
}
