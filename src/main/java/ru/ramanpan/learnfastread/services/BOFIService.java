package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.models.indicators.BOFI;

public interface BOFIService {
    BOFI findById(Long id);

    Long save(IndicatorsDTO indicatorsDTO);
}
