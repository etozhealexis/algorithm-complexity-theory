package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab5DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab5ServiceImpl implements Lab5Service {

    @Override
    public void solveLab5(Lab5DTO request) {
        log.info("Solving");
    }
}
