package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.UserCourses;

public interface UserCoursesRepo extends JpaRepository<UserCourses,Long> {
}
