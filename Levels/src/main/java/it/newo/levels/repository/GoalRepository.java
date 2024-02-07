package it.newo.levels.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.newo.levels.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>{

	Optional<Goal> findByTitle(String title);

}
