package com.gamklk.question_service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gamklk.question_service.dto.wrapper.QuestionWrapper;
import com.gamklk.question_service.models.Question;
import com.gamklk.question_service.repository.QuestionRepository;
import com.gamklk.question_service.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    
    private final QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category){
        return questionRepository.findByCategory(category);
    }

    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    public List<Integer> getQuestionsForQuiz(String categoryName, int numQuestions) {
        List<Integer> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
        return questions.stream().limit(numQuestions).collect(Collectors.toList());
    }
    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> responses = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id: questionIds){
            questions.add(questionRepository.findById(id).get());
        }
        for(Question question : questions){
            QuestionWrapper response = new QuestionWrapper();
            response.setId(question.getId());
            response.setQuestionTitle(question.getQuestionTitle());
            response.setOption1(question.getOption1());
            response.setOption2(question.getOption2());
            response.setOption3(question.getOption3());
            response.setOption4(question.getOption4());
            responses.add(response);
        }

        return responses;
    }

    // public Integer getScore(List<Response> responses) {
    //     int right = 0;
    //     for(Response response : responses){
    //         Question question = questionRepository.findById(response.getId()).get();
    //         if(response.getResponse().equals(question.getRightAnswer())){
    //             right++;
    //         }
    //     }
    //     return right;
    // }
}
