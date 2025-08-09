package com.gamklk.quiz_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamklk.quiz_service.dto.QuizDto;
import com.gamklk.quiz_service.dto.wrapper.QuestionWrapper;
import com.gamklk.quiz_service.models.Quiz;
import com.gamklk.quiz_service.service.QuizService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/quiz")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    
    @PostMapping("/create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto){
        return new ResponseEntity<>(quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle()) , HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return new ResponseEntity<>(quizService.getQuizQuestions(id), HttpStatus.OK);
    }
    
    // @PostMapping("submit/{id}")
    // public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
    //     return quizService.calculateResult(id, responses);
    // }
}
