package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.UserDTO;
import it.newo.levels.model.User;

public interface UserFacade {

	void createAdmin(UserDTO admin);
	void toggleUserActivityStatus(long userID);
	void signUp(UserDTO user);
	void signIn(UserDTO user);
	void unsubscribe(UserDTO user);
	List<UserDTO> getAll();
}
