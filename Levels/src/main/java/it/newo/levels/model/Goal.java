package it.newo.levels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import it.newo.levels.model.enums.Complexity;
import it.newo.levels.model.enums.Priority;
import it.newo.levels.model.enums.Progress;
import lombok.Data;

@Data
@Entity(name = "goals")
public class Goal{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private boolean archived = false;
	
	@Column(nullable = false)
	private String title;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	private Priority priority;
	
	@Column(nullable = false)
	private Complexity complexity;
	
	@Column
	private Progress progress = Progress.PENDING;
	
	@Column(nullable = false)
	
	@OneToMany(mappedBy = "goal")
	private List<Assignment> assignments;
	
	@ManyToMany
	@JoinTable(name = "goal_notes",
					joinColumns = @JoinColumn(name = "goal_id"),
					inverseJoinColumns = @JoinColumn(name = "note_id"))
	private List<Note> notes;
}
