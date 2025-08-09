package com.gamklk.quiz_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gamklk.quiz_service.dto.wrapper.QuestionWrapper;
import com.gamklk.quiz_service.feign.QuizInterface;
import com.gamklk.quiz_service.models.Quiz;
import com.gamklk.quiz_service.repository.QuizRepository;
import com.gamklk.quiz_service.service.QuizService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuizInterface quizInterface;

    public Quiz createQuiz(String category, int numQ, String title){
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions.stream().limit(numQ).collect(Collectors.toList()));
        return quizRepository.save(quiz);
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id){
        Quiz quiz = quizRepository.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        List<QuestionWrapper> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }
}
