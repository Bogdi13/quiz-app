package com.example.ProiectAPI.services;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.FinalAttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.model.Attempt;
import com.example.ProiectAPI.domain.model.Question;
import com.example.ProiectAPI.domain.model.Quiz;
import com.example.ProiectAPI.domain.model.User;
import com.example.ProiectAPI.repository.interfaces.IAttemptRepository;
import com.example.ProiectAPI.repository.interfaces.IQuestionRepository;
import com.example.ProiectAPI.repository.interfaces.IQuizRepository;
import com.example.ProiectAPI.services.interfaces.IAttemptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AttemptService implements IAttemptService {

    @Resource
    private final IAttemptRepository attemptRepository;
    @Resource
    private final IQuizRepository quizRepository;

    public AttemptService(IAttemptRepository attemptRepository, IQuizRepository quizRepository) {
        this.attemptRepository = attemptRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public List<FinalAttemptDTO> findAllByUserId(Long userId) {
        List<Attempt> attempts = this.attemptRepository.findAllByUserId(userId);
        List<FinalAttemptDTO> finalAttemptsDTO = new ArrayList();

        for (Attempt attempt : attempts) {
            FinalAttemptDTO finalAttemptDTO =  new FinalAttemptDTO();
            Optional<Quiz> quiz = this.quizRepository.findById(attempt.getQuizId());
            finalAttemptDTO.setId(attempt.getId());
            quiz.ifPresent(question -> {
                finalAttemptDTO.setQuizTitle(quiz.get().getTitle());
            });
            finalAttemptDTO.setScore(attempt.getScore());
            finalAttemptsDTO.add(finalAttemptDTO);
        }
        return finalAttemptsDTO;
    }

    @Override
    public void save(AttemptDTO attemptDTO) {
        Attempt attempt = new Attempt();
        attempt.setUserId(attemptDTO.getIdUser());
        attempt.setQuizId(attemptDTO.getIdQuiz());
        attempt.setScore(attemptDTO.getScore());
        this.attemptRepository.save(attempt);
    }
}
