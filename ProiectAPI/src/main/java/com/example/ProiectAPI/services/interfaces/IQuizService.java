package com.example.ProiectAPI.services.interfaces;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.dtos.QuizDTO;
import com.example.ProiectAPI.domain.dtos.UserDTO;

import java.util.List;

public interface IQuizService {

    List<QuizDTO> findAll();

    void save(QuizDTO questionDTO);

    void delete(QuizDTO questionDTO);

}
