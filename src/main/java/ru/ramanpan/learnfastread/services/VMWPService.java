package ru.ramanpan.learnfastread.services;

import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.models.indicators.VMWP;

public interface VMWPService {
    VMWP findById(Long id);

    Long save(IndicatorsDTO indicatorsDTO);
}
