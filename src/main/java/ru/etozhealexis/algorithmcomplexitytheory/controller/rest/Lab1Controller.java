package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab1DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab1.Lab1Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_1)
public class Lab1Controller {
    private final Lab1Service lab1Service;

    @GetMapping(LabEndpoint.STATE_MACHINE)
    public void solveLab1WithStateMachine(@RequestBody Lab1DTO request) {
        lab1Service.solveLab1WithStateMachine(request);
    }

    @GetMapping(LabEndpoint.REGEX)
    public void solveLab1WithRegex(@RequestBody Lab1DTO request) {
        lab1Service.solveLab1WithRegex(request);
    }
}
