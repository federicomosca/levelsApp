package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.LoginDTO;
import it.newo.levels.dto.UserDTO;
import it.newo.levels.model.User;

public interface UserFacade {

	void createAdmin(UserDTO admin);
	void toggleUserActivityStatus(long userID);
	void signUp(UserDTO user);
	void signIn(LoginDTO user);
	void unsubscribe(LoginDTO user);
	List<User> getAll();
}
