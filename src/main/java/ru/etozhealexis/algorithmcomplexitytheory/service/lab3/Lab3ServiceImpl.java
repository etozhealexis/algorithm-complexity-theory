package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab3Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab3DTO;
import ru.etozhealexis.algorithmcomplexitytheory.model.Lab3State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab3ServiceImpl implements Lab3Service {
    private Map<Lab3State, HashMap<Character, Character>> graph = new LinkedHashMap<>();

    @Override
    public void solveLab3(Lab3DTO request) {
        String stateSchema = request.getStateSchema();
        if (stateSchema.length() == Lab3Constant.NO_STATES_LENGTH) {
            log.info(Lab3Constant.VALID_DFA_MESSAGE);
            return;
        }

        List<String> strings = new LinkedList<>(Arrays.asList(stateSchema.split(Lab3Constant.ENTER)));
        String dopStates = strings.get(strings.size() - 1);
        strings.remove(strings.size() - 1);
        List<String> stateStrings = strings.stream()
                .filter(el -> el.length() == Lab3Constant.STATE_STRING_LENGTH)
                .toList();

        buildGraph(stateStrings, dopStates);
        log.info(String.valueOf(graph));

        int onesCount = 0;
        Lab3State startState = getFirstState(graph);
        Set<Lab3State> visitedStates = new HashSet<>();
        boolean isValidDKA = checkDKA(startState, graph, visitedStates, onesCount);

        if (isValidDKA) {
            log.info(Lab3Constant.VALID_DFA_MESSAGE);
        } else {
            log.info(Lab3Constant.NOT_VALID_DFA_MESSAGE);
        }

        graph.clear();
    }

    private void buildGraph(List<String> stateStrings, String dopStates) {
        stateStrings.forEach(
                state -> {
                    Lab3State currentState;
                    if (dopStates.contains(String.valueOf(state.charAt(Lab3Constant.CURRENT_STATE_POSITION)))) {
                        currentState = Lab3State.builder()
                                .name(state.charAt(Lab3Constant.CURRENT_STATE_POSITION))
                                .status(Lab3State.Lab3StateStatus.ACCEPT)
                                .build();
                    } else {
                        currentState = Lab3State.builder()
                                .name(state.charAt(Lab3Constant.CURRENT_STATE_POSITION))
                                .status(Lab3State.Lab3StateStatus.DENY)
                                .build();
                    }
                    if (graph.get(currentState) != null) {
                        HashMap<Character, Character> stateElement = graph.get(currentState);
                        if (stateElement != null) {
                            stateElement.put(state.charAt(Lab3Constant.VALUE_POSITION), state.charAt(Lab3Constant.NEXT_STATE_POSITION));
                        } else {
                            stateElement = new HashMap<>();
                            stateElement.put(state.charAt(Lab3Constant.VALUE_POSITION), state.charAt(Lab3Constant.NEXT_STATE_POSITION));
                        }
                        graph.put(currentState, stateElement);
                    } else {
                        HashMap<Character, Character> stateElement = new HashMap<>();
                        stateElement.put(state.charAt(Lab3Constant.VALUE_POSITION), state.charAt(Lab3Constant.NEXT_STATE_POSITION));
                        graph.put(currentState, stateElement);
                    }
                }
        );
    }

    private Lab3State getFirstState(Map<Lab3State, HashMap<Character, Character>> graph) {
        Map.Entry<Lab3State, HashMap<Character, Character>> entry = graph.entrySet().iterator().next();
        return entry.getKey();
    }

    private boolean checkDKA(Lab3State currentState, Map<Lab3State, HashMap<Character, Character>> graph, Set<Lab3State> visitedStates, int onesCount) {
        Lab3State.Lab3StateStatus currentStateStatus = currentState.getStatus();
        if (currentStateStatus == Lab3State.Lab3StateStatus.ACCEPT && isOdd(onesCount)) {
            return true;
        }

        HashMap<Character, Character> currentStateInfo = graph.get(currentState);

        for (Map.Entry<Character, Character> entry : currentStateInfo.entrySet()) {
            Lab3State nextState = Lab3State.builder().name(entry.getValue()).build();
            int nextOnesCount = nextState.getName().equals(Lab3Constant.ONE) ? onesCount + 1 : onesCount;
            if (visitedStates.contains(nextState)) {
                continue;
            }
            visitedStates.add(nextState);

            if (checkDKA(nextState, graph, visitedStates, nextOnesCount)) {
                return true;
            }
            visitedStates.remove(nextState);
        }

        return false;
    }

    private boolean isOdd(int onesCount) {
        return onesCount % 2 == 0;
    }
}
