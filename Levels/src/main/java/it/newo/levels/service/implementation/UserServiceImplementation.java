package it.newo.levels.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.User;
import it.newo.levels.repository.UserRepository;
import it.newo.levels.service.definition.UserService;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository store;
	

	@Override
	public void save(User user) {
		store.save(user);
	}

	@Override
	public User get(long id) {
		return store.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public User get(String username) {
		return store.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Override
		public List<User> getAll() {
			return store.findAll();
		}
	
	@Override
	public User authenticate(String username, String password) {
		return store.authenticate(username, password);
	}

	

}
