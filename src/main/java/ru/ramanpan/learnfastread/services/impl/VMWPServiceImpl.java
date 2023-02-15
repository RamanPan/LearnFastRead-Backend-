package ru.ramanpan.learnfastread.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.learnfastread.dto.IndicatorsDTO;
import ru.ramanpan.learnfastread.exceptions.NotFoundException;
import ru.ramanpan.learnfastread.models.indicators.VMWP;
import ru.ramanpan.learnfastread.repositories.VMWPRepo;
import ru.ramanpan.learnfastread.services.UserService;
import ru.ramanpan.learnfastread.services.VMWPService;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VMWPServiceImpl implements VMWPService{
    private final VMWPRepo vmwpRepo;
    private final UserService userService;

    @Override
    public VMWP findById(Long id) {
        return vmwpRepo.findById(id).orElseThrow(() -> new NotFoundException("VM indicator not found"));
    }

    @Override
    public Long save(IndicatorsDTO indicatorsDTO) {
        VMWP vmwp = new VMWP();
        vmwp.setVmwp(indicatorsDTO.getValue());
        vmwp.setRegisterDate(LocalDate.now());
        vmwp.setUser(userService.findById(indicatorsDTO.getIdUser()));
        return vmwpRepo.save(vmwp).getId();
    }
}
