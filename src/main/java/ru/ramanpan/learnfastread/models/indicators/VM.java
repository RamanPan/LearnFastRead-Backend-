package ru.ramanpan.learnfastread.models.indicators;

import lombok.*;
import org.hibernate.Hibernate;
import ru.ramanpan.learnfastread.models.BaseEntity;
import ru.ramanpan.learnfastread.models.User;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table
@Entity
public class VM extends BaseEntity {
    private Integer vm;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VM vm = (VM) o;
        return getId() != null && Objects.equals(getId(), vm.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
