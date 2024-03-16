package ru.etozhealexis.algorithmcomplexitytheory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab2DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab2.Lab2Service;

@RestController
@RequiredArgsConstructor
public class Lab2Controller {
    private final Lab2Service lab2Service;

    @GetMapping("/lab2/sm")
    public void solveLab1WithStateMachine(@RequestBody Lab2DTO request) {
        lab2Service.solveLab2WithStateMachine(request);
    }

    @GetMapping("/lab2/regex")
    public void solveLab1WithRegex(@RequestBody Lab2DTO request) {
        lab2Service.solveLab2WithRegex(request);
    }
}
