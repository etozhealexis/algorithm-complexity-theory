package ru.etozhealexis.algorithmcomplexitytheory.service.lab4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab4.OutputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab4ServiceMock implements Lab4Service {

    @Override
    public OutputDTO solveLab4(LabInputDTO request) {
        log.info("Solving...");
        return null;
    }
}
