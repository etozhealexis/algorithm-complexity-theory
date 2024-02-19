package ru.etozhealexis.algorithmcomplexitytheory.service.lab2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("DEV")
@Service
public class Lab2ServiceMock implements Lab2Service {

    @Override
    public void solveLab2() {
        log.info("Solving...");
    }
}
