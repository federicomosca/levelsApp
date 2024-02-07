package it.newo.levels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.newo.levels.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
