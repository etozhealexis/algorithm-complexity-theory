package ru.etozhealexis.algorithmcomplexitytheory.service.lab3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab3Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab3DTO;
import ru.etozhealexis.algorithmcomplexitytheory.model.Lab3State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab3ServiceImpl implements Lab3Service {
    private HashMap<Lab3State, HashMap<Character, Character>> graph = new HashMap<>();

    @Override
    public void solveLab3(Lab3DTO request) {
        String stateSchema = request.getStateSchema();
        if (stateSchema.length() == Lab3Constant.NO_STATES_LENGTH) {
            log.info("True");
            return;
        }

        List<String> strings = Arrays.asList(stateSchema.split(Lab3Constant.ENTER));
        String dopStates = strings.get(strings.size() - 1);
        strings.remove(dopStates);
        List<String> stateStrings = strings.stream()
                .filter(el -> el.length() == Lab3Constant.STATE_STRING_LENGTH)
                .toList();

        buildGraph(stateStrings, dopStates);
        log.info(String.valueOf(graph));

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
}
