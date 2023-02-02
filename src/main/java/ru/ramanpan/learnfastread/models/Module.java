package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "modules")
@Entity
public class Module extends BaseEntity{
    @Column(nullable = false)
    private Integer number;

    @Column(length = 100,nullable = false)
    private String title;

    @Column(length = 1000)
    private String overview;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Module module = (Module) o;
        return getId() != null && Objects.equals(getId(), module.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
