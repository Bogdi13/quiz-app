package com.example.ProiectAPI.repository.interfaces;

import com.example.ProiectAPI.domain.model.Quiz;
import com.example.ProiectAPI.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuizRepository extends JpaRepository<Quiz, Long> {
}
