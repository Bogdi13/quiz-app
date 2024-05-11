package com.example.ProiectAPI.services.interfaces;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.dtos.QuestionQuizDTO;

import java.util.List;

public interface IQuestionQuizService {
    void saveQuestionInQuiz(Long idQuestion, Long idQuiz) throws Exception;
    public List<QuestionDTO> findAllByQuizId(Long quizId);
}
