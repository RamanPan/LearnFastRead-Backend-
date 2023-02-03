package ru.ramanpan.learnfastread.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TaskDTO {
    private Long id;
    private Long idTaskToken;
    private Long idTaskTarget;
    private Long idTaskTargetAudience;
    private Long idTaskMethod;
    private Long idTaskRSP;
    private Long idTaskTheme;
    private Long idTaskTest;
    private Long idTaskTestProp;
    private Long idTaskType;
    private LocalDate dateCreate;
    private LocalDate dateUpdate;
    private Integer number;
    private String title;
    private String overview;
    private String author;
    private Boolean adaptivity;
    private Boolean control;
    private Boolean individual;
    private Boolean toQER;
    private Boolean toBOFI;
    private Boolean toAA;
    private Boolean toVM;
    private Boolean toVMWP;
    private Boolean toLM;

}
