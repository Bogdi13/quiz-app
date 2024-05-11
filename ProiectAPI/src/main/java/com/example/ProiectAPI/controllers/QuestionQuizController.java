package com.example.ProiectAPI.controllers;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.dtos.QuestionQuizDTO;
import com.example.ProiectAPI.services.interfaces.IAttemptService;
import com.example.ProiectAPI.services.interfaces.IQuestionQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questionsQuizzes")
public class QuestionQuizController {

    @Resource
    private final IQuestionQuizService questionQuizService;

    public QuestionQuizController(IQuestionQuizService questionQuizService) {
        this.questionQuizService = questionQuizService;
    }

    @PostMapping("/{idQuestion}/{idQuiz}")
    public ResponseEntity<String> addQuestionInQuiz(@PathVariable Long idQuestion, @PathVariable Long idQuiz) throws Exception {
        try{
            this.questionQuizService.saveQuestionInQuiz(idQuestion, idQuiz);
            return null;
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<List<QuestionDTO>> findAllQuestionsByQuizId(@PathVariable Long quizId){
        List<QuestionDTO> questionDTOS = questionQuizService.findAllByQuizId(quizId);
        if(questionDTOS != null) {
            return new ResponseEntity<>(questionDTOS, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
