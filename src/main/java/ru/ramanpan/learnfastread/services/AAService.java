package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.models.indicators.AA;

public interface AAService {
    AA findById(Long id);

    Long save(IndicatorsDTO indicatorsDTO);
}
