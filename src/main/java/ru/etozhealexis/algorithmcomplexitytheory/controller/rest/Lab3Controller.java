package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab3.Lab3Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_3)
public class Lab3Controller {
    private final Lab3Service lab3Service;

    @PostMapping(LabEndpoint.SOLVE)
    public ResponseEntity<String> solveLab3(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab3Service.solveLab3(request));
    }

    @PostMapping(LabEndpoint.CLEAR)
    public void clearGraph() {
        lab3Service.clearGraph();
    }
}
