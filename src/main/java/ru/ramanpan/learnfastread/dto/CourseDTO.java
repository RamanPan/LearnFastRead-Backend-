package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {
    private Long id;
    private LocalDate registerDate;
    private LocalDate changesDate;
    private String title;
    private String overview;
    private String author;
}
