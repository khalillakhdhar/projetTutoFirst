package com.repo.controllers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repo.entities.Tutorial;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TutorialController {

	@Autowired
	TutorialServiceImplement tutorialService;
	@GetMapping("tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title)
	{
		return tutorialService.getAllTutorials(title);
	}
	@GetMapping("tutorials/{id}")

	public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id)
	{
		return tutorialService.getTutorialById(id);
		
	}
	@PostMapping("tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial)
	{
		return tutorialService.createTutorial(tutorial);
	}
	@DeleteMapping("tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id)
	{
		return tutorialService.deleteTutorial(id);
	}
}
