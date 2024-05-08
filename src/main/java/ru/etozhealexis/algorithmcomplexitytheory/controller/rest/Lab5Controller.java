package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab5.Lab5Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_5)
public class Lab5Controller {

    private final Lab5Service lab5Service;

    @GetMapping(LabEndpoint.SOLVE)
    public void solveLab5(@RequestBody LabInputDTO request) {
        lab5Service.solveLab5(request);
    }
}
