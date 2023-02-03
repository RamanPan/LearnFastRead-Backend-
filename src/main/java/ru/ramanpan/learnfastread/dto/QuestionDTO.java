package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuestionDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private Long idItem;
    private Integer number;
    private String statement;
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
}
