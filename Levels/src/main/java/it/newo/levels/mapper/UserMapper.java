package it.newo.levels.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import it.newo.levels.dto.UserDTO;
import it.newo.levels.model.User;
import it.newo.levels.model.UsersGoals;
import it.newo.levels.model.UsersTasks;

@Component
public class UserMapper {

	public User fromDTO(UserDTO dto, List<UsersGoals> goals, List<UsersTasks> tasks) {
		
		User u = new User();
		u.setRole(dto.getRole());
		u.setName(dto.getName());
		u.setSurname(dto.getSurname());
		u.setEmail(dto.getEmail());
		u.setPassword(dto.getPassword());
		u.setActive(dto.isActive());
		
		if(goals != null) {
			u.setGoals(goals);
		}
		
		if(tasks != null) {
			u.setTasks(tasks);
		}
		
		return u;
	}
	
	public UserDTO toDTO(User u, long[] goalsIDs, long[] tasksIDs) {
		UserDTO dto = new UserDTO();
		dto.setRole(u.getRole());
		dto.setName(u.getName());
		dto.setSurname(u.getSurname());
		dto.setEmail(u.getEmail());
		dto.setPassword(u.getPassword());
		dto.setActive(u.isActive());
		
		if(goalsIDs != null) {
			dto.setGoalsIDs(goalsIDs);
		}
		
		if(tasksIDs != null) {
			dto.setTasksIDs(tasksIDs);
		}
		
		return dto;
	}
}
