package ru.ramanpan.learnfastread.models.indicators;

import lombok.*;
import org.hibernate.Hibernate;
import ru.ramanpan.learnfastread.models.BaseEntity;
import ru.ramanpan.learnfastread.models.User;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class QER extends BaseEntity {
    @Column(length = 45)
    private String qer;

    @Column(length = 45)
    private String wpm;

    @Column(length = 45)
    private String qu;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        QER qer = (QER) o;
        return getId() != null && Objects.equals(getId(), qer.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
