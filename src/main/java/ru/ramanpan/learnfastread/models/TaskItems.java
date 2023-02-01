package ru.ramanpan.learnfastread.models;

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
public class TaskItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTaskItems;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    @ToString.Exclude
    private Task task;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TaskItems taskItems = (TaskItems) o;
        return idTaskItems != null && Objects.equals(idTaskItems, taskItems.idTaskItems);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
