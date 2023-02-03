package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDailyDTO {
    private Long id;
    private Long idUser;
    private Integer amountOfTasks;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
}
