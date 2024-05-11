package com.example.ProiectAPI.domain.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttemptDTO {
    private Long id;
    private Long idUser;
    private Long idQuiz;
    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Long idQuiz) {
        this.idQuiz = idQuiz;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
