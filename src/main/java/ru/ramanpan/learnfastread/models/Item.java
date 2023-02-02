package ru.ramanpan.learnfastread.models;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Item extends BaseEntity{
    @Column(length = 100)
    private String title;

    private String file;

    @Column(length = 10000)
    private String content;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return getId() != null && Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
