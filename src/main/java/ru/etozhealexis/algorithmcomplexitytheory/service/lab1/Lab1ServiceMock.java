package ru.etozhealexis.algorithmcomplexitytheory.service.lab1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab1DTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab1ServiceMock implements Lab1Service {

    @Override
    public void solveLab1WithStateMachine(Lab1DTO request) {
        log.info("Solving...");
    }

    @Override
    public void solveLab1WithRegex(Lab1DTO request) {
        log.info("Solving...");
    }
}
