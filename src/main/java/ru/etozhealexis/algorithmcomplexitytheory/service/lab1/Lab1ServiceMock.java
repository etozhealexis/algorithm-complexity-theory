package ru.etozhealexis.algorithmcomplexitytheory.service.lab1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab1ServiceMock implements Lab1Service {

    @Override
    public String solveLab1WithStateMachine(LabInputDTO request) {
        log.info("Solving...");
        return null;
    }

    @Override
    public String solveLab1WithRegex(LabInputDTO request) {
        log.info("Solving...");
        return null;
    }
}
