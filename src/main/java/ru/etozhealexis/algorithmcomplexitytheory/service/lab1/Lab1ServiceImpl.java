package ru.etozhealexis.algorithmcomplexitytheory.service.lab1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab1Constant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.enums.Lab1State;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;

import java.util.regex.Pattern;

@Slf4j
@Service
public class Lab1ServiceImpl implements Lab1Service {

    private final Pattern pattern;

    @Autowired
    public Lab1ServiceImpl(@Qualifier("lab1Pattern") Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String solveLab1WithStateMachine(LabInputDTO request) {
        String word = request.getRequest();
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
        String message;
        if (lab1State == Lab1State.STATE_2 || lab1State == Lab1State.STATE_3) {
            message = String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word);
            log.error(message);
        } else {
            message = String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word);
            log.info(message);
        }
        return message;
    }

    @Override
    public String solveLab1WithRegex(LabInputDTO request) {
        String word = request.getRequest();
        String message;
        if ((word.length() == Lab1Constant.MIN_WRONG_WORD_LENGTH || word.length() == Lab1Constant.MAX_WRONG_WORD_LENGTH)
                && pattern.matcher(word).find()) {
            message = String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word);
            log.error(message);
        } else {
            message = String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word);
            log.info(message);
        }
        return message;
    }

    private Lab1State nextState(char currentLetter, Lab1State nextState) {
        return currentLetter == Lab1Constant.ZERO ? Lab1State.STATE_4 : nextState;
    }
}
