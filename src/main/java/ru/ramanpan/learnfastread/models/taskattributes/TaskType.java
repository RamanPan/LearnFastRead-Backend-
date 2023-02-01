package ru.ramanpan.learnfastread.models.taskattributes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TaskType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskType;
    @Column(nullable = false, length = 50)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskType taskType = (TaskType) o;
        return idTaskType != null && Objects.equals(idTaskType, taskType.idTaskType);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
