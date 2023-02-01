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
public class TaskTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskTest;
    @Column(nullable = false, length = 50)
    private String test;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskTest taskTest = (TaskTest) o;
        return idTaskTest != null && Objects.equals(idTaskTest, taskTest.idTaskTest);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
