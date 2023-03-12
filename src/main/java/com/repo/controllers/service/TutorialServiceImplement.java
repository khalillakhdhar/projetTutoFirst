package com.repo.controllers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.repo.entities.Tutorial;
import com.repo.exception.ResourceNotFoundException;
import com.repo.repositories.TutorialDetailsRepository;
import com.repo.repositories.TutorialRepository;
import java.util.List;
@Service
public class TutorialServiceImplement implements TutorialsService {
@Autowired
private TutorialRepository tutorialRepository;
@Autowired
private  TutorialDetailsRepository tutorialDetailsRepository;
	
	@Override
	public ResponseEntity<List<Tutorial>> getAllTutorials(String title) {
		// TODO Auto-generated method stub
		List<Tutorial> tutorials=new ArrayList<>();
		if(title==null)
			tutorialRepository.findAll().forEach(tutorials::add); // ajout plus rapide par éléments
		else
			tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
		
		return new ResponseEntity<>(tutorials,HttpStatus.OK);
				
	}

	@Override
	public ResponseEntity<Tutorial> getTutorialById(long id) {
		// TODO Auto-generated method stub
		Tutorial tutorial=tutorialRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Not found tutorial with id="+id));
		return new ResponseEntity<>(tutorial,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		Tutorial _tutorial=tutorialRepository.save(tutorial);
		
		return new ResponseEntity<>(_tutorial,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteTutorial(long id) {
		// TODO Auto-generated method stub
		if(tutorialDetailsRepository.existsById(id))
		{
			tutorialDetailsRepository.deleteById(id);
			
		}
		tutorialRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	@Override
	public ResponseEntity<List<Tutorial>> findBypublished() {
		// TODO Auto-generated method stub
		List<Tutorial> tutorials=tutorialRepository.findByPublished(true);
		if(tutorials.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(tutorials,HttpStatus.OK);
	}

}
