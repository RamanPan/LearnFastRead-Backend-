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
public class TaskTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskTheme;
    @Column(nullable = false, length = 50)
    private String theme;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskTheme taskTheme = (TaskTheme) o;
        return idTaskTheme != null && Objects.equals(idTaskTheme, taskTheme.idTaskTheme);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
