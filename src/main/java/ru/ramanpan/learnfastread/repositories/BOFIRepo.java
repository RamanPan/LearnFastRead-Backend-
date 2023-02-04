package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.indicators.BOFI;

public interface BOFIRepo extends JpaRepository<BOFI, Long> {
}