package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

public interface Lab3Service {
    String solveLab3(LabInputDTO request);
    void clearGraph();
}
