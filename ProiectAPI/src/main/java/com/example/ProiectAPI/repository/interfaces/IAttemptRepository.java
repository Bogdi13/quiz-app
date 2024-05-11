package com.example.ProiectAPI.repository.interfaces;

import com.example.ProiectAPI.domain.model.Attempt;
import com.example.ProiectAPI.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAttemptRepository extends JpaRepository<Attempt,Long> {
    List<Attempt> findAllByUserId(Long userId);
}
