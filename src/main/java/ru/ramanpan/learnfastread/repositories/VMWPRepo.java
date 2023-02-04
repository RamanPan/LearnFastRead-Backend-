package ru.ramanpan.learnfastread.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.learnfastread.models.indicators.VMWP;

public interface VMWPRepo extends JpaRepository<VMWP, Long> {
}