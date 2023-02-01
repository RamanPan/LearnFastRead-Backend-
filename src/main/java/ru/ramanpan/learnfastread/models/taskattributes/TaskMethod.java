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
public class TaskMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskMethod;
    @Column(nullable = false, length = 50)
    private String method;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskMethod that = (TaskMethod) o;
        return idTaskMethod != null && Objects.equals(idTaskMethod, that.idTaskMethod);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
