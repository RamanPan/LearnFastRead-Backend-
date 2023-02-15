package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.VM;
import ru.ramanpan.learnfastread.repositories.VMRepo;
import ru.ramanpan.learnfastread.services.UserService;
import ru.ramanpan.learnfastread.services.VMService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VMServiceImpl implements VMService {
    private final VMRepo vmRepo;
    private final UserService userService;

    @Override
    public VM findById(Long id) {
        return vmRepo.findById(id).orElseThrow(() -> new NotFoundException("VM indicator not found"));
    }

    @Override
    public Long save(IndicatorsDTO indicatorsDTO) {
        VM vm = new VM();
        vm.setVm(indicatorsDTO.getValue());
        vm.setRegisterDate(LocalDate.now());
        vm.setUser(userService.findById(indicatorsDTO.getIdUser()));
        return vmRepo.save(vm).getId();
    }
}
