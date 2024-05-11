package com.example.ProiectAPI.repository.interfaces;

import com.example.ProiectAPI.domain.model.QuestionQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQuestionQuizRepository extends JpaRepository<QuestionQuiz,Long> {
    List<QuestionQuiz> findAllByQuizId(Long quizId);
}
