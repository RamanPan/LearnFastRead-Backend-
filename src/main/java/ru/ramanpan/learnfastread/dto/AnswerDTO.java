package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AnswerDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private Long idUserTask;
    private Integer number;
    private String ans;
}
