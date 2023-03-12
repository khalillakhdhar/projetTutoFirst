package com.repo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.entities.Tag;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
