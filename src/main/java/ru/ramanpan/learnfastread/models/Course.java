package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Course extends BaseEntity {
    @Column(length = 70)
    private String title;

    @Column(length = 100)
    private String overview;

    @Column(name = "created_by", length = 50)
    private String author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return getId() != null && Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
