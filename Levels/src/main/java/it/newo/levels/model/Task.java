package it.newo.levels.model;

import java.util.List;

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
import lombok.Data;

@Data
@Entity(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private boolean done = false;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	@OneToMany(mappedBy="task")
	private List<Assignment> assignments;
	
	@ManyToMany
	@JoinTable(name = "task_notes",
					joinColumns = @JoinColumn(name = "task_id"),
					inverseJoinColumns = @JoinColumn(name = "note_id"))
	private List<Note> notes;
}
