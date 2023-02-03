package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskItemDTO {
    private Long id;
    private Long idTask;
    private Long idItem;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
}
