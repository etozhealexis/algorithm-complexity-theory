package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab1.Lab1Service;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_1)
public class Lab1Controller {
    private final Lab1Service lab1Service;

    @GetMapping(LabEndpoint.STATE_MACHINE)
    public ResponseEntity<String> solveLab1WithStateMachine(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab1Service.solveLab1WithStateMachine(request));
    }

    @GetMapping(LabEndpoint.REGEX)
    public ResponseEntity<String> solveLab1WithRegex(@RequestBody LabInputDTO request) {
        return ResponseEntity.ok(lab1Service.solveLab1WithRegex(request));
    }
}
