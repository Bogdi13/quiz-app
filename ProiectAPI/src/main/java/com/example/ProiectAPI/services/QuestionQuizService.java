package com.example.ProiectAPI.services;

import com.example.ProiectAPI.domain.dtos.AttemptDTO;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.dtos.QuestionQuizDTO;
import com.example.ProiectAPI.domain.model.Attempt;
import com.example.ProiectAPI.domain.model.Question;
import com.example.ProiectAPI.domain.model.QuestionQuiz;
import com.example.ProiectAPI.domain.model.Quiz;
import com.example.ProiectAPI.repository.interfaces.IAttemptRepository;
import com.example.ProiectAPI.repository.interfaces.IQuestionQuizRepository;
import com.example.ProiectAPI.repository.interfaces.IQuestionRepository;
import com.example.ProiectAPI.repository.interfaces.IQuizRepository;
import com.example.ProiectAPI.services.interfaces.IQuestionQuizService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionQuizService implements IQuestionQuizService {

    @Resource
    private final IQuestionQuizRepository questionQuizRepository;

    @Resource
    private final IQuestionRepository questionRepository;

    @Resource
    private final IQuizRepository quizRepository;

    public QuestionQuizService(IQuestionQuizRepository questionQuizRepository, IQuestionRepository questionRepository, IQuizRepository quizRepository) {
        this.questionQuizRepository = questionQuizRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    public void saveQuestionInQuiz(Long idQuestion, Long idQuiz) throws Exception {
        QuestionQuiz questionQuiz = new QuestionQuiz();
        Optional<Question> questionOptional = questionRepository.findById(idQuestion);
        Optional<Quiz> quizOptional = quizRepository.findById(idQuiz);
        if (questionOptional.isPresent()) {
            questionQuiz.setQuestionId(idQuestion);
        } else {
            throw new Exception("Intrebarea nu exista");
        }
        if (quizOptional.isPresent()) {
            questionQuiz.setQuizId(idQuiz);
        } else {
            throw new Exception("Quizul nu exista");
        }
        this.questionQuizRepository.save(questionQuiz);
    }

    @Override
    public List<QuestionDTO> findAllByQuizId(Long quizId) {
        List<QuestionQuiz> questionsQuizes = this.questionQuizRepository.findAllByQuizId(quizId);
        List<Question> questions = new ArrayList<>();

        for (QuestionQuiz questionQuiz : questionsQuizes){
            Optional<Question> temp = this.questionRepository.findById(questionQuiz.getQuestionId());
            temp.ifPresent(questions::add);
        }
        List<QuestionDTO> questionsDTO = new ArrayList();

        for (Question question : questions) {
            QuestionDTO qestionDTO = new QuestionDTO();
            qestionDTO.setId(question.getId());
            qestionDTO.setText(question.getText());
            qestionDTO.setChoiceA(question.getChoiceA());
            qestionDTO.setChoiceB(question.getChoiceB());
            qestionDTO.setChoiceC(question.getChoiceC());
            qestionDTO.setCorrectChoice(question.getCorrectChoice());
            questionsDTO.add(qestionDTO);
        }
        return questionsDTO;
    }

}
