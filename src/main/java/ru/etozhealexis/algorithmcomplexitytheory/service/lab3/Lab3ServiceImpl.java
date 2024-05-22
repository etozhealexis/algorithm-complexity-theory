package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab3Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.model.lab3.State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab3ServiceImpl implements Lab3Service {
    private final Map<State, HashMap<Character, Character>> graph = new LinkedHashMap<>();

    @Override
    public String solveLab3(LabInputDTO request) {
        String stateSchema = request.getRequest();
        String message;
        if (stateSchema.length() == Lab3Constant.NO_STATES_LENGTH) {
            message = Lab3Constant.VALID_DFA_MESSAGE;
            log.info(message);
            return message;
        }

        List<String> strings = new LinkedList<>(Arrays.asList(stateSchema.split(Lab3Constant.ENTER)));
        strings.forEach(log::info);
        String dopStates = strings.get(strings.size() - 1);
        strings.remove(strings.size() - 1);
        List<String> stateStrings = strings.stream()
                .filter(el -> el.length() == Lab3Constant.STATE_STRING_LENGTH)
                .toList();

        buildGraph(stateStrings, dopStates);
        log.info(String.valueOf(graph));
        //  4\n1 0 4\n1 1 2\n2 0 4\n2 1 3\n3 0 4\n3 1 4\n4 0 4\n4 1 4\n3
        int onesCount = 0;
        State startState = getFirstState(graph);
        Set<State> visitedStates = new HashSet<>();
        boolean isValidDFA = checkDFA(startState, graph, visitedStates, onesCount);

        if (isValidDFA) {
            message = Lab3Constant.VALID_DFA_MESSAGE;
            log.info(message);
        } else {
            message = Lab3Constant.NOT_VALID_DFA_MESSAGE;
            log.error(message);
        }

        return message;
    }

    @Override
    public void clearGraph() {
        graph.clear();
    }

    private void buildGraph(List<String> stateStrings, String dopStates) {
        stateStrings.forEach(
                state -> {
                    State currentState;
                    if (dopStates.contains(String.valueOf(state.charAt(Lab3Constant.CURRENT_STATE_POSITION)))) {
                        currentState = State.builder()
                                .name(state.charAt(Lab3Constant.CURRENT_STATE_POSITION))
                                .status(State.Lab3StateStatus.ACCEPT)
                                .build();
                    } else {
                        currentState = State.builder()
                                .name(state.charAt(Lab3Constant.CURRENT_STATE_POSITION))
                                .status(State.Lab3StateStatus.DENY)
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

    private State getFirstState(Map<State, HashMap<Character, Character>> graph) {
        Map.Entry<State, HashMap<Character, Character>> entry = graph.entrySet().iterator().next();
        return entry.getKey();
    }

    // toDo: замена на false на true не помогает, посмотреть в сторону составления transitionMap (мне пизда)
    private boolean checkDFA(State currentState,
                             Map<State, HashMap<Character, Character>> graph,
                             Set<State> visitedStates,
                             int onesCount) {
        log.info(String.format(Lab3Constant.CHECKING_DFA_STATE_MESSAGE, currentState));
        State.Lab3StateStatus currentStateStatus = currentState.getStatus();
        if (currentStateStatus == State.Lab3StateStatus.ACCEPT && !isOdd(onesCount)) {
            return false;
        }

        HashMap<Character, Character> currentStateInfo = graph.get(currentState);

        for (Map.Entry<Character, Character> entry : currentStateInfo.entrySet()) {
            State nextState = getNextState(graph, entry);
            int nextOnesCount = entry.getKey().equals(Lab3Constant.ONE) ? onesCount + 1 : onesCount;
            if (visitedStates.contains(nextState)) {
                continue;
            }
            visitedStates.add(nextState);
            if (!checkDFA(nextState, graph, visitedStates, nextOnesCount)) {
                return false;
            }
            visitedStates.remove(nextState);
        }

        return true;
    }

    private boolean isOdd(int onesCount) {
        return onesCount % 2 == 0;
    }

    private State getNextState(Map<State, HashMap<Character, Character>> graph, Map.Entry<Character, Character> entry) {
        Optional<State> nextState = graph.keySet().stream()
                .filter(key -> key.equals(State.builder()
                        .name(entry.getValue()).build()))
                .findFirst();
        return State.builder()
                .name(nextState.map(State::getName).orElse(null))
                .status(nextState.map(State::getStatus).orElse(null))
                .build();
    }
}
