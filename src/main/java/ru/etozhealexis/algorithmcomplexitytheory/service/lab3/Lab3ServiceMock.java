package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("DEV")
@Service
public class Lab3ServiceMock implements Lab3Service {

    @Override
    public void solveLab3() {
        log.info("Solving...");
    }
}
