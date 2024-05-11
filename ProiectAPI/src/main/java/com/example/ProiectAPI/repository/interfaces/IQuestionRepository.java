package com.example.ProiectAPI.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProiectAPI.domain.model.Question;

import java.util.Optional;

public interface IQuestionRepository extends JpaRepository<Question,Long> {
}
