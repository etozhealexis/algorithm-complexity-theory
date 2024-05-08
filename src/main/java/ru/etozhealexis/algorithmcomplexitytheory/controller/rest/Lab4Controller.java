package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab4DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab4.Lab4Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_4)
public class Lab4Controller {

    private final Lab4Service lab4Service;

    @GetMapping(LabEndpoint.SOLVE)
    public void solveLab4(@RequestBody Lab4DTO request) {
        lab4Service.solveLab4(request);
    }
}
