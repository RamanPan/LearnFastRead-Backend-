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
public class TaskToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskToken;
    @Column(nullable = false, length = 50)
    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskToken taskToken = (TaskToken) o;
        return idTaskToken != null && Objects.equals(idTaskToken, taskToken.idTaskToken);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
