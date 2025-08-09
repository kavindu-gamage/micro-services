package com.gamklk.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamklk.quiz_service.dto.response.Response;
import com.gamklk.quiz_service.dto.wrapper.QuestionWrapper;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("api/question/generate")
    public List<Integer> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions);

    @PostMapping("api/question/getQuestions")
    public List<QuestionWrapper> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("api/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
