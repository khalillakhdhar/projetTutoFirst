package com.repo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.entities.TutorialDetails;

import jakarta.transaction.Transactional;
@Repository // automatique avec sp3
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {
@Transactional
void deleteById(long id);
@Transactional
void deleteTutorialById(long tutorialId);
}
