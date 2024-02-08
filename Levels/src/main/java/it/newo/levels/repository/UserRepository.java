package it.newo.levels.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.newo.levels.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);

	@Query("select u from users u where username =: username and password =: password")
	User authenticate(String username, String password);
}
