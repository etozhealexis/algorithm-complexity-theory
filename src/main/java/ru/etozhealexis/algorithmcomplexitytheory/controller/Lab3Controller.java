package ru.etozhealexis.algorithmcomplexitytheory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab3DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab3.Lab3Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_3)
public class Lab3Controller {
    private final Lab3Service lab3Service;

    @GetMapping(LabEndpoint.STATE_MACHINE)
    public void solveLab1WithStateMachine(@RequestBody Lab3DTO request) {
        lab3Service.solveLab3WithStateMachine(request);
    }

    @GetMapping(LabEndpoint.REGEX)
    public void solveLab1WithRegex(@RequestBody Lab3DTO request) {
        lab3Service.solveLab3WithRegex(request);
    }
}
