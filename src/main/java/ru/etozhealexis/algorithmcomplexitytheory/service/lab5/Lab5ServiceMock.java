package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("DEV")
@Service
public class Lab5ServiceMock implements Lab5Service {

    @Override
    public void solveLab5() {
        log.info("Solving...");
    }
}