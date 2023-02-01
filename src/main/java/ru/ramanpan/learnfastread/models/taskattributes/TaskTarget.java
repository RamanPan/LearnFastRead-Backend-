package ru.ramanpan.learnfastread.models.taskattributes;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TaskTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskTarget;
    @Column(nullable = false, length = 50)
    private String target;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskTarget that = (TaskTarget) o;
        return idTaskTarget != null && Objects.equals(idTaskTarget, that.idTaskTarget);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
