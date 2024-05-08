package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab6.BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab6ServiceMock implements Lab6Service {

    @Override
    public BoardDTO getBoard() {
        log.info("Getting board...");
        return null;
    }

    @Override
    public BoardDTO makeTurn(LabInputDTO lab6DTO) {
        log.info("Making turn...");
        return null;
    }

    @Override
    public void clearBoard() {
        log.info("Clearing...");
    }

    @Override
    public boolean checkGameEnd() {
        return false;
    }
}