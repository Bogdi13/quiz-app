package com.example.ProiectAPI.services;
import com.example.ProiectAPI.domain.dtos.QuestionDTO;
import com.example.ProiectAPI.domain.dtos.QuizDTO;
import com.example.ProiectAPI.domain.model.Question;
import com.example.ProiectAPI.domain.model.QuestionQuiz;
import com.example.ProiectAPI.domain.model.Quiz;
import com.example.ProiectAPI.repository.interfaces.IQuestionQuizRepository;
import com.example.ProiectAPI.repository.interfaces.IQuestionRepository;
import com.example.ProiectAPI.repository.interfaces.IQuizRepository;
import com.example.ProiectAPI.services.interfaces.IQuestionQuizService;
import com.example.ProiectAPI.services.interfaces.IQuestionService;
import com.example.ProiectAPI.services.interfaces.IQuizService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService implements IQuizService {

    @Resource
    private final IQuizRepository quizRepository;

    public QuizService(IQuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<QuizDTO> findAll() {
        List<Quiz> quizes = this.quizRepository.findAll();
        List<QuizDTO> quizesDTO = new ArrayList();

        for (Quiz quiz : quizes) {
            QuizDTO qDTO = new QuizDTO();
            qDTO.setTitle(quiz.getTitle());
            qDTO.setId(quiz.getId());
            quizesDTO.add(qDTO);
        }
        return quizesDTO;
    }

    @Override
    public void save(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setId(quizDTO.getId());
        quiz.setTitle(quizDTO.getTitle());
        this.quizRepository.save(quiz);
    }

    @Override
    public void delete(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setId(quizDTO.getId());
        quiz.setTitle(quizDTO.getTitle());
        this.quizRepository.delete(quiz);
    }

}
