package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;
import ru.ramanpan.learnfastread.models.taskattributes.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task extends BaseEntity {
    private Integer number;

    @Column(length = 100,nullable = false)
    private String title;

    @Column(length = 500)
    private String overview;

    @Column(length = 100,name = "created_by",nullable = false)
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

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_token_id_task_token")
    @ToString.Exclude
    private TaskToken taskToken;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_target_id_task_target")
    @ToString.Exclude
    private TaskTarget taskTarget;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_method_id_task_method")
    @ToString.Exclude
    private TaskMethod taskMethod;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_rsp_id_task_rsp")
    @ToString.Exclude
    private TaskRSP taskRSP;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_theme_id_task_theme")
    @ToString.Exclude
    private TaskTheme taskTheme;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_target_audience_id_task_target_audience")
    @ToString.Exclude
    private TaskTargetAudience taskTargetAudience;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_test_id_task_test")
    @ToString.Exclude
    private TaskTest taskTest;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_test_prop_id_task_test_prop")
    @ToString.Exclude
    private TaskTestProp taskTestProp;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_type_id_task_type")
    @ToString.Exclude
    private TaskType taskType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;
        return getId() != null && Objects.equals(getId(), task.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
