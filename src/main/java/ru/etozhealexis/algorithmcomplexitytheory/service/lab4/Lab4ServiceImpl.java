package ru.etozhealexis.algorithmcomplexitytheory.service.lab4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab4DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab4ServiceImpl implements Lab4Service {

    @Override
    public void solveLab4(Lab4DTO request) {
        log.info("Solving");
    }
}
