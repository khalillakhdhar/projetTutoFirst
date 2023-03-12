package com.repo.controllers.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.repo.entities.Tutorial;
public interface TutorialsService {
public ResponseEntity<List<Tutorial>> getAllTutorials(String title);
public ResponseEntity<Tutorial> getTutorialById(long id);
public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial);
// retourne soit un tutorial soit le message d'exception précis => facilite le fait de suivre les exception
public ResponseEntity<HttpStatus> deleteTutorial(long id);
public ResponseEntity<List<Tutorial>> findBypublished();
}
