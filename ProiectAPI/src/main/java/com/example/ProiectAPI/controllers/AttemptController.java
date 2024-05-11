package com.example.ProiectAPI.controllers;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.FinalAttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.services.interfaces.IAttemptService;
import com.example.ProiectAPI.services.interfaces.IQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/attempts")
public class AttemptController {

    @Resource
    private final IAttemptService attemptService;

    public AttemptController(IAttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FinalAttemptDTO>> findAllAttemptsByUserId(@PathVariable Long userId){
        List<FinalAttemptDTO> finalAttemptsDTO = attemptService.findAllByUserId(userId);
        if(finalAttemptsDTO != null) {
            return new ResponseEntity<>(finalAttemptsDTO, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<Void> addAttempt(@RequestBody AttemptDTO attemptDTO){
        this.attemptService.save(attemptDTO);
        return null;
    }
}
