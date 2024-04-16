package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab6ServiceImpl implements Lab6Service {

    @Override
    public void solveLab6(Lab6DTO request) {
        log.info("Solving");
    }
}
