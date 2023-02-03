package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserTaskDTO {
    private Long id;
    private Long idModuleTask;
    private Long idUserTask;
    private Integer time;
    private Integer correctness;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
}
