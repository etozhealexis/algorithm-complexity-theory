package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

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

    @GetMapping(LabEndpoint.SOLVE)
    public void solveLab3(@RequestBody Lab3DTO request) {
        lab3Service.solveLab3(request);
    }
}
