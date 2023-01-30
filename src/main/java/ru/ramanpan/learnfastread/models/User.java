package ru.ramanpan.learnfastread.models;

import lombok.*;
import org.hibernate.Hibernate;
import ru.ramanpan.learnfastread.models.enums.Role;
import ru.ramanpan.learnfastread.models.indicators.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
public class User extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 70, nullable = false)
    private String email;
    @Column(length = 70, nullable = false)
    private String password;

    @Column(name = "first_name", length = 30)
    private String firstname;

    @Column(name = "last_name", length = 30)
    private String lastname;

    @Column(name = "icon", length = 100)
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_admin")
    private Role role;

    @Column(name = "task_in_day")
    private Integer taskInDay;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AA> aaList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<QER> qerList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<VM> vmList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<LM> lmList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<VMWP> vmwpList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<BOFI> bofiList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
