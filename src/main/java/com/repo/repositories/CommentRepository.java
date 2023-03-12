package com.repo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.entities.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
