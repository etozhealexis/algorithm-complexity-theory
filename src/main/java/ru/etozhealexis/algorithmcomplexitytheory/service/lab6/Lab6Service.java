package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import ru.etozhealexis.algorithmcomplexitytheory.dto.lab6.BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

public interface Lab6Service {
    BoardDTO getBoard();
    BoardDTO makeTurn(LabInputDTO lab6DTO);
    void clearBoard();
    boolean checkGameEnd();
}
