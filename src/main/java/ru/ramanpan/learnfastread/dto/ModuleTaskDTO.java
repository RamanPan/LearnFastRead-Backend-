package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuleTaskDTO {
    private Long id;
    private Long idModule;
    private Long idTask;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
}
