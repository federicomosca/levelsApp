package it.newo.levels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import it.newo.levels.facade.definition.UserFacade;

@RestController
public class UserController {
	
	@Autowired
	private UserFacade facade;

	
}
