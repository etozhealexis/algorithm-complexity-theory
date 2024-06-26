package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.InputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.OutputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab5ServiceMock implements Lab5Service {

    @Override
    public OutputDTO solveLab5(InputDTO request) {
        log.info("Solving...");
        return null;
    }

    @Override
    public void clearMap() {
        log.info("Clearing...");
    }
}