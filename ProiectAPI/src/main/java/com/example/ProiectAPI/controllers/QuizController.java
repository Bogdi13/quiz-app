package com.example.ProiectAPI.controllers;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuizDTO;
import com.example.ProiectAPI.services.interfaces.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProiectAPI.services.interfaces.IUserService;
import com.example.ProiectAPI.domain.dtos.UserDTO;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/quizes")
public class QuizController {

    @Resource
    private final IQuizService quizService;

    public QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping("/")
    public ResponseEntity<List<QuizDTO>> getAllQuizes(){
        List<QuizDTO> quizesDTO = quizService.findAll();
        if(quizesDTO != null) {
            return new ResponseEntity<>(quizesDTO, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addQuiz(@RequestBody QuizDTO quizDTO){
        this.quizService.save(quizDTO);
        return null;
    }
}
