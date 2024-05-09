package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab2.OutputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab2.Lab2Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_2)
public class Lab2Controller {
    private final Lab2Service lab2Service;

    @PostMapping(LabEndpoint.STATE_MACHINE)
    public ResponseEntity<OutputDTO> solveLab2WithStateMachine(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab2Service.solveLab2WithStateMachine(request));
    }

    @PostMapping(LabEndpoint.CLEAR)
    public void clearGraph() {
        lab2Service.clearStack();
    }

    @PostMapping(LabEndpoint.REGEX)
    public ResponseEntity<String> solveLab2WithRegex(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab2Service.solveLab2WithRegex(request));
    }
}
