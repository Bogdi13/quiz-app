package com.example.ProiectAPI.services.interfaces;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.FinalAttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;

import java.util.List;

public interface IAttemptService {
    List<FinalAttemptDTO> findAllByUserId(Long userId);

    void save(AttemptDTO attemptDTO);
}
