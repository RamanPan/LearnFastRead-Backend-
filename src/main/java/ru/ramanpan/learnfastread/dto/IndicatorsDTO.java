package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IndicatorsDTO {
    private Long id;
    private Long idUser;
    private Integer value;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
}
