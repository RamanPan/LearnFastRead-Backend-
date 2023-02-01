package ru.ramanpan.learnfastread.models.taskattributes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "task_rsp")
@Entity
public class TaskRSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskRSP;
    @Column(nullable = false, length = 50)
    private String rsp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskRSP taskRSP = (TaskRSP) o;
        return idTaskRSP != null && Objects.equals(idTaskRSP, taskRSP.idTaskRSP);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
