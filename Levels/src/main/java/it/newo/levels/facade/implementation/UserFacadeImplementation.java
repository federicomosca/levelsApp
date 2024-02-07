package it.newo.levels.facade.implementation;

import java.util.List;

import it.newo.levels.dto.UserDTO;
import it.newo.levels.facade.definition.UserFacade;
import it.newo.levels.mapper.UserMapper;
import it.newo.levels.service.definition.GoalService;
import it.newo.levels.service.definition.TaskService;
import it.newo.levels.service.definition.UserService;

public class UserFacadeImplementation implements UserFacade {
	
	private UserService userService;
	
	private UserMapper userMapper;
	
	private GoalService goalService;
	
	private TaskService taskService;

	@Override
	public void newAdmin(UserDTO admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableUser(long userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableUser(long userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void signUp(UserDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsubscribe(UserDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
