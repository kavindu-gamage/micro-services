package com.gamklk.quiz_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gamklk.quiz_service.dto.wrapper.QuestionWrapper;
import com.gamklk.quiz_service.models.Quiz;

@Service
public interface QuizService {
    Quiz createQuiz(String category, int numQ, String title);
    List<QuestionWrapper> getQuizQuestions(Integer id);
}
