package com.example.ProiectAPI.controllers;


import com.example.ProiectAPI.domain.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProiectAPI.services.interfaces.IQuestionService;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Resource
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<QuestionDTO> findAllQuestions() {
        return this.questionService.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Void> addQuestion(@RequestBody QuestionDTO questionDTO){
        this.questionService.save(questionDTO);
        return null;
    }
}
