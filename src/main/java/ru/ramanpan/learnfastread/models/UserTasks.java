package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;
import ru.ramanpan.learnfastread.models.enums.Correctness;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserTasks extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "module_task_id")
    @ToString.Exclude
    private ModuleTask moduleTask;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_task_id")
    @ToString.Exclude
    private UserTasks userTask;

    private Integer time;

    @Enumerated(EnumType.ORDINAL)
    private Correctness correctness;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserTasks userTasks = (UserTasks) o;
        return getId() != null && Objects.equals(getId(), userTasks.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
