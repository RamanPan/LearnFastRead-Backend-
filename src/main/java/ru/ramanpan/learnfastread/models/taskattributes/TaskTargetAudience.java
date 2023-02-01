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
public class TaskTargetAudience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskTargetAudience;
    @Column(nullable = false, length = 50)
    private String targetAudience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskTargetAudience that = (TaskTargetAudience) o;
        return idTaskTargetAudience != null && Objects.equals(idTaskTargetAudience, that.idTaskTargetAudience);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
