package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.BOFI;
import ru.ramanpan.learnfastread.repositories.BOFIRepo;
import ru.ramanpan.learnfastread.services.BOFIService;
import ru.ramanpan.learnfastread.services.UserService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class BOFIServiceImpl implements BOFIService {
    private final BOFIRepo bofiRepo;
    private final UserService userService;

    @Override
    public BOFI findById(Long id) {
        return bofiRepo.findById(id).orElseThrow(() -> new NotFoundException("BOFI not found"));
    }

    @Override
    public Long save(IndicatorsDTO indicatorsDTO) {
        BOFI b = new BOFI();
        b.setBofi(indicatorsDTO.getValue());
        b.setRegisterDate(LocalDate.now());
        b.setUser(userService.findById(indicatorsDTO.getIdUser()));
        return bofiRepo.save(b).getId();
    }
}
