package com.example.ProiectAPI.services;

import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.model.Question;
import com.example.ProiectAPI.domain.model.QuestionQuiz;
import com.example.ProiectAPI.domain.model.User;
import com.example.ProiectAPI.repository.interfaces.IQuestionQuizRepository;
import com.example.ProiectAPI.repository.interfaces.IQuestionRepository;
import com.example.ProiectAPI.services.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProiectAPI.repository.interfaces.IUserRepository;
import com.example.ProiectAPI.domain.dtos.UserDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Resource
    private final IQuestionRepository questionRepository;

    @Resource
    private final IQuestionQuizRepository questionQuizRepository;

    public QuestionService(IQuestionRepository questionRepository, IQuestionQuizRepository questionQuizRepository) {
        this.questionRepository = questionRepository;
        this.questionQuizRepository = questionQuizRepository;
    }

    @Override
    public List<QuestionDTO> findAll() {
        List<Question> questions = this.questionRepository.findAll();
        List<QuestionDTO> questionsDTO = new ArrayList();

        for (Question question : questions) {
            QuestionDTO qDTO = new QuestionDTO();
            qDTO.setId(question.getId());
            qDTO.setChoiceA(question.getChoiceA());
            qDTO.setChoiceB(question.getChoiceB());
            qDTO.setChoiceC(question.getChoiceC());
            qDTO.setCorrectChoice(question.getCorrectChoice());
            qDTO.setText(question.getText());
            questionsDTO.add(qDTO);
        }
        return questionsDTO;
    }

    @Override
    public void save(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setChoiceA(questionDTO.getChoiceA());
        question.setChoiceB(questionDTO.getChoiceB());
        question.setChoiceC(questionDTO.getChoiceC());
        question.setCorrectChoice(questionDTO.getCorrectChoice());
        question.setText(questionDTO.getText());

        this.questionRepository.save(question);
    }

    @Override
    public void delete(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setChoiceA(questionDTO.getChoiceA());
        question.setChoiceB(questionDTO.getChoiceB());
        question.setChoiceC(question.getChoiceC());
        question.setCorrectChoice(question.getCorrectChoice());

        this.questionRepository.delete(question);
    }

}
