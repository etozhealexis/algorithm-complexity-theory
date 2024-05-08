package ru.etozhealexis.algorithmcomplexitytheory.service.lab1;

import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

public interface Lab1Service {
    String solveLab1WithStateMachine(LabInputDTO request);

    String solveLab1WithRegex(LabInputDTO request);
}
