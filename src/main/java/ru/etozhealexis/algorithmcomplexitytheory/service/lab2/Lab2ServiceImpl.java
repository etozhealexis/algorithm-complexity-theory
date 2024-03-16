package ru.etozhealexis.algorithmcomplexitytheory.service.lab2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab2Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab2DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab2ServiceImpl implements Lab2Service {

    @Override
    public void solveLab2WithStateMachine(Lab2DTO request) {
        log.info("Solving");
    }

    @Override
    public void solveLab2WithRegex(Lab2DTO request) {
        String word = request.getWord();
        int zeros = word.replace(Lab2Constant.ONE, Lab2Constant.VOID).length();
        int ones = word.replace(Lab2Constant.ZERO, Lab2Constant.VOID).length();
        if (zeros >= ones * 2) {
            log.info(String.format(Lab2Constant.SUITABLE_WORD_MESSAGE, word));
        } else {
            log.info(String.format(Lab2Constant.NOT_SUITABLE_WORD_MESSAGE, word));
        }
    }
}
