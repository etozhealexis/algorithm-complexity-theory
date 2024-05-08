package ru.etozhealexis.algorithmcomplexitytheory.service.lab2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab2Constant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.enums.Lab2State;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab2DTO;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab2ServiceImpl implements Lab2Service {
    private Deque<Character> stack = new ArrayDeque<>();

    @Override
    public void solveLab2WithStateMachine(Lab2DTO request) {
        String word = request.getWord();
        Lab2State lab2State = Lab2State.INITIAL_STATE;
        StringBuilder stateHistory = new StringBuilder(Lab2State.INITIAL_STATE.getStateName()).append(Lab2Constant.DIVIDER);

        for (int i = 0; i < word.length(); i++) {
            final char letter = word.charAt(i);
            if (lab2State.equals(Lab2State.INITIAL_STATE)) {
                lab2State = Lab2State.STATE_1;
                stateHistory.append(Lab2State.STATE_1.getStateName()).append(Lab2Constant.DIVIDER);
            }
            lab2State = switch (lab2State) {
                case STATE_1 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_2.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_2;
                    } else {
                        stateHistory.append(Lab2State.STATE_5.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_5;
                    }
                }
                case STATE_2 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_2.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_2;
                    } else {
                        stateHistory.append(Lab2State.STATE_3.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_3;
                    }
                }
                case STATE_3 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_3.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_3;
                    } else {
                        stack.pop();
                        stateHistory.append(Lab2State.STATE_2.getStateName()).append(Lab2Constant.DIVIDER);
                        if (stack.isEmpty()) {
                            stateHistory.append(Lab2State.STATE_4.getStateName()).append(Lab2Constant.DIVIDER);
                            yield Lab2State.STATE_4;
                        }
                        yield Lab2State.STATE_2;
                    }
                }
                case STATE_5 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_3.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_3;
                    } else {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_6.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_6;
                    }
                }
                case STATE_6 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.pop();
                        stateHistory.append(Lab2State.STATE_8.getStateName()).append(Lab2Constant.DIVIDER);
                        if (stack.isEmpty()) {
                            stateHistory.append(Lab2State.STATE_4.getStateName()).append(Lab2Constant.DIVIDER);
                            yield Lab2State.STATE_4;
                        }
                        yield Lab2State.STATE_8;
                    } else {
                        stateHistory.append(Lab2State.STATE_7.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_7;
                    }
                }
                case STATE_7 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.pop();
                        stateHistory.append(Lab2State.STATE_9.getStateName()).append(Lab2Constant.DIVIDER);
                        if (stack.isEmpty()) {
                            stateHistory.append(Lab2State.STATE_10.getStateName()).append(Lab2Constant.DIVIDER);
                            yield Lab2State.STATE_10;
                        }
                        yield Lab2State.STATE_9;
                    } else {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_6.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_6;
                    }
                }
                case STATE_8 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.pop();
                        stateHistory.append(Lab2State.STATE_8.getStateName()).append(Lab2Constant.DIVIDER);
                        if (stack.isEmpty()) {
                            stateHistory.append(Lab2State.STATE_4.getStateName()).append(Lab2Constant.DIVIDER);
                            yield Lab2State.STATE_4;
                        }
                        yield Lab2State.STATE_8;
                    } else {
                        yield Lab2State.STATE_9;
                    }
                }
                case STATE_9 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.pop();
                        stateHistory.append(Lab2State.STATE_9.getStateName()).append(Lab2Constant.DIVIDER);
                        if (stack.isEmpty()) {
                            stateHistory.append(Lab2State.STATE_10.getStateName()).append(Lab2Constant.DIVIDER);
                            yield Lab2State.STATE_10;
                        }
                        yield Lab2State.STATE_9;
                    } else {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_8.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_8;
                    }
                }
                case STATE_4 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_2.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_2;
                    } else {
                        stateHistory.append(Lab2State.STATE_10.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_10;
                    }
                }
                case STATE_10 -> {
                    if (letter == Lab2Constant.ONE.charAt(0)) {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_3.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_3;
                    } else {
                        stack.add(letter);
                        stateHistory.append(Lab2State.STATE_8.getStateName()).append(Lab2Constant.DIVIDER);
                        yield Lab2State.STATE_8;
                    }
                }
                default -> throw new IllegalStateException(CommonConstant.ILLEGAL_STATE_MESSAGE + lab2State);
            };
        }

        if (stack.isEmpty() && (lab2State.equals(Lab2State.STATE_2) || lab2State.equals(Lab2State.STATE_8))) {
            stateHistory.append(Lab2State.STATE_4.getStateName()).append(Lab2Constant.DIVIDER);
            lab2State = Lab2State.STATE_4;
        }
        if (stack.isEmpty() && (lab2State.equals(Lab2State.STATE_3) || lab2State.equals(Lab2State.STATE_9))) {
            stateHistory.append(Lab2State.STATE_10.getStateName()).append(Lab2Constant.DIVIDER);
            lab2State = Lab2State.STATE_10;
        }

        String stateHistoryString = stateHistory.toString().trim();
        log.info(String.format(Lab2Constant.STATE_HISTORY_MESSAGE, stateHistoryString.substring(0, stateHistoryString.length() - 1)));

        StringBuilder stackElements = new StringBuilder();
        stack.forEach(element -> stackElements.append(element).append(Lab2Constant.DIVIDER));
        String stackElementsString = stackElements.toString().trim();
        if (stack.isEmpty()) {
            log.info(Lab2Constant.EMPTY_STACK_MESSAGE);
        } else {
            log.info(String.format(Lab2Constant.STACK_ELEMENTS_MESSAGE, stackElementsString.substring(0, stackElementsString.length() - 1)));
        }

        if (lab2State.equals(Lab2State.STATE_8) || lab2State.equals(Lab2State.STATE_9) ||
                lab2State.equals(Lab2State.STATE_4) || lab2State.equals(Lab2State.STATE_10)) {
            log.info(String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word));
        } else {
            log.error(String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word));
        }

        stack.clear();
    }

    @Override
    public void solveLab2WithRegex(Lab2DTO request) {
        String word = request.getWord();
        int zeros = word.replace(Lab2Constant.ONE, CommonConstant.VOID).length();
        int ones = word.replace(Lab2Constant.ZERO, CommonConstant.VOID).length();
        if (zeros >= ones * 2) {
            log.info(String.format(CommonConstant.SUITABLE_WORD_MESSAGE, word));
        } else {
            log.error(String.format(CommonConstant.NOT_SUITABLE_WORD_MESSAGE, word));
        }
    }
}
