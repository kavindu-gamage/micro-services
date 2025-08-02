package com.gamklk.question_service.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamklk.question_service.dto.wrapper.QuestionWrapper;
import com.gamklk.question_service.models.Question;
import com.gamklk.question_service.service.QuestionService;

import lombok.RequiredArgsConstructor;





@RestController
@RequestMapping("api/question")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        List<Question> categories = questionService.getQuestionsByCategory(category);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question newQuestion = questionService.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuestion);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions) {
        List<Integer> questions = questionService.getQuestionsForQuiz(categoryName, numQuestions);
        return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        List<QuestionWrapper> questionWarpper = questionService.getQuestionsFromId(questionIds);
        return ResponseEntity.status(HttpStatus.OK).body(questionWarpper);
    }
    
    // @PostMapping("/getScore")
    // public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
    //     int score = questionService.getScore(responses);
    //     return ResponseEntity.status(HttpStatus.OK).body(score);
    // }
    
    
}
