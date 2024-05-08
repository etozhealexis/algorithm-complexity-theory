package ru.etozhealexis.algorithmcomplexitytheory.service.lab4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab4ServiceMock implements Lab4Service {

    @Override
    public void solveLab4(LabInputDTO request) {
        log.info("Solving...");
    }
}
