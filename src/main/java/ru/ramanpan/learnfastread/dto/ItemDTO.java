package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ItemDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private String title;
    private String file;
    private String content;
}
