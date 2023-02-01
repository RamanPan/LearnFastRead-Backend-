package ru.ramanpan.learnfastread.models.taskattributes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TaskTestProp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskTestProp;
    @Column(nullable = false, length = 50)
    private String testProp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskTestProp that = (TaskTestProp) o;
        return idTaskTestProp != null && Objects.equals(idTaskTestProp, that.idTaskTestProp);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
