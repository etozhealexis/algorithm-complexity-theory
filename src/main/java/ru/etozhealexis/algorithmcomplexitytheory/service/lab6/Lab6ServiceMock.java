package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab6ServiceMock implements Lab6Service {

    @Override
    public void solveLab6(Lab6DTO request) {
        log.info("Solving...");
    }
}