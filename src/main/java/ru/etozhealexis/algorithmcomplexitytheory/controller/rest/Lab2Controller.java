package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab2DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab2.Lab2Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_2)
public class Lab2Controller {
    private final Lab2Service lab2Service;

    @GetMapping(LabEndpoint.STATE_MACHINE)
    public void solveLab1WithStateMachine(@RequestBody Lab2DTO request) {
        lab2Service.solveLab2WithStateMachine(request);
    }

    @GetMapping(LabEndpoint.REGEX)
    public void solveLab1WithRegex(@RequestBody Lab2DTO request) {
        lab2Service.solveLab2WithRegex(request);
    }
}
