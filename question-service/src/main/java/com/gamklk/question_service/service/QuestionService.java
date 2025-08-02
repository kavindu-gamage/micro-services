package com.gamklk.question_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gamklk.question_service.dto.wrapper.QuestionWrapper;
import com.gamklk.question_service.models.Question;

@Service
public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    Question addQuestion(Question question);
    List<Integer> getQuestionsForQuiz(String categoryName, int numQuestions);
    List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds);
    //Integer getScore(List<Response> responses);
}
