package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.OutputDTO;

public interface Lab5Service {
    OutputDTO solveLab5(LabInputDTO request);
    void clearSet();
}
