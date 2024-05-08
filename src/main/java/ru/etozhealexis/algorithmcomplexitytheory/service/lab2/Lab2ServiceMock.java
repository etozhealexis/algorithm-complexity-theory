package ru.etozhealexis.algorithmcomplexitytheory.service.lab2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab2ServiceMock implements Lab2Service {

    @Override
    public void solveLab2WithStateMachine(LabInputDTO request) {
        log.info("Solving...");
    }

    @Override
    public void solveLab2WithRegex(LabInputDTO request) {
        log.info("Solving...");
    }
}
