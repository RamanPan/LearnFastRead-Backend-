package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModuleDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private Integer number;
    private String title;
    private String overview;
}
