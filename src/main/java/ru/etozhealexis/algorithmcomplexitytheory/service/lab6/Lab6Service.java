package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;

public interface Lab6Service {
    Lab6BoardDTO getBoard();
    Lab6BoardDTO makeTurn(Lab6DTO lab6DTO);
    void clearBoard();
    boolean checkGameEnd();
}
