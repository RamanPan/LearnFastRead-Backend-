package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Answer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_tasks_id")
    @ToString.Exclude
    private UserTasks userTasks;

    private Integer number;

    @Column(length = 100)
    private String ans;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Answer answer = (Answer) o;
        return getId() != null && Objects.equals(getId(), answer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
