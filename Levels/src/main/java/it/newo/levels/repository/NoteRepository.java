package it.newo.levels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.newo.levels.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

}
