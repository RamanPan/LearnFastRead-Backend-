package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "questions")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Question extends BaseEntity {
    private Integer number;

    @Column(nullable = false, length = 300)
    private String statement;

    @Column(nullable = false, length = 100)
    private String answerOne;

    @Column(length = 100)
    private String answerTwo;

    @Column(length = 100)
    private String answerThree;

    @Column(length = 100)
    private String answerFour;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Question question = (Question) o;
        return getId() != null && Objects.equals(getId(), question.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
