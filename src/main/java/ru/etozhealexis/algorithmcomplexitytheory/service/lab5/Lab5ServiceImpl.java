package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab5Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.OutputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.model.lab5.SetElement;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class Lab5ServiceImpl implements Lab5Service {

    private final Pattern pattern;
    private final Set<SetElement> set;

    @Autowired
    public Lab5ServiceImpl(@Qualifier("lab5Pattern") Pattern pattern) {
        this.pattern = pattern;
        this.set = new LinkedHashSet<>();
    }

    // toDo: ничего не понятно, очень интересно
    @Override
    public OutputDTO solveLab5(LabInputDTO request) {
        String setString = request.getRequest();
        long start = System.currentTimeMillis();
        String message;
        try {
            fillSet(setString);
            if (set.isEmpty()) {
                message = String.format(Lab5Constant.VERIFICATION_FAILED_MESSAGE, Lab5Constant.EMPTY_SET_MESSAGE);
                log.error(message);
            } else {
                message = Lab5Constant.VERIFICATION_PASSED_MESSAGE;
                log.info(message);
            }
        } catch (IllegalStateException exception) {
            message = String.format(Lab5Constant.VERIFICATION_FAILED_MESSAGE, exception.getMessage());
            log.error(message);
        }
        long end = System.currentTimeMillis();
        String timeExecutionMessage = String.format(CommonConstant.TIME_EXECUTION_MESSAGE, end - start);
        log.info(timeExecutionMessage);
        return OutputDTO.builder()
                .message(message)
                .timeExecutionMessage(timeExecutionMessage)
                .build();
    }

    @Override
    public void clearSet() {
        set.clear();
    }

    private void fillSet(String setString) {
        Matcher matcher = pattern.matcher(setString);
        while (matcher.find()) {
            String element = matcher.group();
            element = element.replaceAll(Lab5Constant.EXTRA_ELEMENTS_DELETION_REGEX, CommonConstant.VOID);
            List<String> colors = Arrays.stream(element.split(Lab5Constant.DIVIDER)).toList();
            if (colors.get(Lab5Constant.FIRST_ELEMENT_INDEX).equals(colors.get(Lab5Constant.SECOND_ELEMENT_INDEX))) {
                throw new IllegalStateException(Lab5Constant.SAME_COLORS_MESSAGE);
            }
            SetElement setElement = SetElement.builder()
                    .colors(colors)
                    .build();
            if (set.contains(setElement)) {
                throw new IllegalStateException(Lab5Constant.DUPLICATE_ELEMENT_MESSAGE);
            }
            set.add(setElement);
        }
    }
}
