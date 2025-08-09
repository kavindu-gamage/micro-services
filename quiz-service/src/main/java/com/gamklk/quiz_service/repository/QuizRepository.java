package com.gamklk.quiz_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamklk.quiz_service.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    
}
