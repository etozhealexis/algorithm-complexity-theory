package ru.etozhealexis.algorithmcomplexitytheory.service.lab1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.config.Lab1Config;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab1Constant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.enums.Lab1State;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab1DTO;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab1ServiceImpl implements Lab1Service {

    private final Lab1Config lab1Config;

    @Override
    public void solveLab1WithStateMachine(Lab1DTO request) {
        String word = request.getWord();
        Lab1State lab1State = Lab1State.INITIAL_STATE;
        for (int i = 0; i < word.length(); i++) {
            switch (lab1State) {
                case INITIAL_STATE ->
                        lab1State = nextState(word.charAt(i), Lab1State.STATE_1);
                case STATE_1 ->
                        lab1State = nextState(word.charAt(i), Lab1State.STATE_2);
                case STATE_2 ->
                        lab1State = nextState(word.charAt(i), Lab1State.STATE_3);
                case STATE_3 ->
                        lab1State = Lab1State.STATE_4;
                default ->
                        throw new IllegalStateException(String.format(CommonConstant.ILLEGAL_STATE_MESSAGE, lab1State));
            }
            if (lab1State == Lab1State.STATE_4) {
                break;
            }
        }
        if (lab1State == Lab1State.STATE_2 || lab1State == Lab1State.STATE_3) {
            log.info(String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word));
        } else {
            log.info(String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word));
        }
    }

    @Override
    public void solveLab1WithRegex(Lab1DTO request) {
        String word = request.getWord();
        if ((word.length() == Lab1Constant.MIN_WRONG_WORD_LENGTH || word.length() == Lab1Constant.MAX_WRONG_WORD_LENGTH)
                && lab1Config.getPattern().matcher(word).find()) {
            log.error(String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word));
        } else {
            log.info(String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word));
        }
    }

    private Lab1State nextState(char currentLetter, Lab1State nextState) {
        return currentLetter == Lab1Constant.ZERO ? Lab1State.STATE_4 : nextState;
    }
}
