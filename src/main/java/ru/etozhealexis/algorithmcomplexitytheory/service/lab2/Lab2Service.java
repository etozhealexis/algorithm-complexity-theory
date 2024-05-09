package ru.etozhealexis.algorithmcomplexitytheory.service.lab2;

import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab2.OutputDTO;

public interface Lab2Service {
    OutputDTO solveLab2WithStateMachine(LabInputDTO request);
    void clearStack();
    String solveLab2WithRegex(LabInputDTO request);
}
