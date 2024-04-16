package ru.etozhealexis.algorithmcomplexitytheory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab6.Lab6Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_6)
public class Lab6Controller {

    private final Lab6Service lab6Service;

    @GetMapping(LabEndpoint.SOLVE)
    public void solveLab5(@RequestBody Lab6DTO request) {
        lab6Service.solveLab6(request);
    }
}
