package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;

@Slf4j
@Profile("DEV")
@Service
public class Lab6ServiceMock implements Lab6Service {

    @Override
    public Lab6BoardDTO getBoard() {
        log.info("Getting board...");
        return null;
    }

    @Override
    public Lab6BoardDTO makeTurn(Lab6DTO lab6DTO) {
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