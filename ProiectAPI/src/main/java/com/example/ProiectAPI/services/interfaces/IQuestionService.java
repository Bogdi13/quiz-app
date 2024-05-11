package com.example.ProiectAPI.services.interfaces;

import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.model.Question;

import java.util.List;

public interface IQuestionService {
    List<QuestionDTO> findAll();

    void save(QuestionDTO questionDTO);

    void delete(QuestionDTO questionDTO);
}
