package it.newo.levels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.newo.levels.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
