package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskAttributesDTO {
    private Long id;
    private String statement;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
 }
