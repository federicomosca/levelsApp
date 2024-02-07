package it.newo.levels.facade.definition;

import java.util.List;

import it.newo.levels.dto.UserDTO;

public interface UserFacade {

	void newAdmin(UserDTO admin);
	void disableUser(long userID);
	void enableUser(long userID);
	void signUp(UserDTO user);
	void unsubscribe(UserDTO user);
	List<UserDTO> getAll();
}
