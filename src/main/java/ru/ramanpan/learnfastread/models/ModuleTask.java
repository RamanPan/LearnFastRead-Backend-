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
public class ModuleTask extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "module_id")
    @ToString.Exclude
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "task_id")
    @ToString.Exclude
    private Task task;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ModuleTask that = (ModuleTask) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
