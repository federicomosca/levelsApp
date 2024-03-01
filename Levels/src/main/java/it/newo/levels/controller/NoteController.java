package it.newo.levels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.newo.levels.facade.definition.NoteFacade;

@RestController
@RequestMapping("note")
public class NoteController {

	@Autowired
	private NoteFacade facade;
}
