package it.newo.levels.service.definition;

import java.util.List;

import it.newo.levels.model.User;

public interface UserService {

	void save(User user);
	User get(long id);
	User get(String username);
	User authenticate(String username, String password);
	List<User> getAll();
}
