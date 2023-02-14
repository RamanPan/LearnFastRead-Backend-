package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QerDTO {
    private Long id;
    private String qer;
    private String wpm;
    private String qu;
    private LocalDate dateRegister;
    private Long userId;
}
