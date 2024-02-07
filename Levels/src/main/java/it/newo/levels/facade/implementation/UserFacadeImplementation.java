package it.newo.levels.facade.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.newo.levels.dto.UserDTO;
import it.newo.levels.facade.definition.UserFacade;
import it.newo.levels.mapper.UserMapper;
import it.newo.levels.model.User;
import it.newo.levels.service.definition.UserService;

@Service
public class UserFacadeImplementation implements UserFacade {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void newAdmin(UserDTO admin) {
		userService.save(userMapper.fromDTO(admin));
	}

	@Override
	public void disableUser(long userID) {
		User u = userService.get(userID);
		if(u.isActive()) u.setActive(false);
		userService.save(u);
	}

	@Override
	public void enableUser(long userID) {
		User u = userService.get(userID);
		if(!u.isActive()) u.setActive(true);
		userService.save(u);
	}

	@Override
	public void signUp(UserDTO user) {
		userService.save(userMapper.fromDTO(user));
	}

	@Override
	public void signIn(UserDTO user) {
		userService.authenticate(user.getUsername(), user.getPassword());
	}

	@Override
	public void unsubscribe(UserDTO user) {
		User u = userMapper.fromDTO(user);
		u.setActive(false);
		userService.save(u);
	}
}
