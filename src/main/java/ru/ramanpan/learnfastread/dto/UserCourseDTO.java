package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCourseDTO {
    private Long id;
    private Long idUser;
    private Long idCourse;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
    private LocalDate dateClose;
}
