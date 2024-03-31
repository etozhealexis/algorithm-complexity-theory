package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab3DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab3ServiceImpl implements Lab3Service {

    @Override
    public void solveLab3WithStateMachine(Lab3DTO request) {
        log.info(request.getStateSchema());
        log.info("Solving");
    }

    @Override
    public void solveLab3WithRegex(Lab3DTO request) {
        log.info("Solving");
    }
}
