package com.example.ProiectAPI.domain.dtos;

public class FinalAttemptDTO {
    private Long id;
    private String quizTitle;
    private int score;

    public FinalAttemptDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
