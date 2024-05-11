package com.example.ProiectAPI.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String correctChoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public void setCorrectChoice(String correctChoice) {
        this.correctChoice = correctChoice;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

