package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab4.OutputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab4.Lab4Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_4)
public class Lab4Controller {

    private final Lab4Service lab4Service;

    @PostMapping(LabEndpoint.SOLVE)
    public ResponseEntity<OutputDTO> solveLab4(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab4Service.solveLab4(request));
    }
}
