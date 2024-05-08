package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab5Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab5DTO;
import ru.etozhealexis.algorithmcomplexitytheory.model.Lab5SetElement;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab5ServiceImpl implements Lab5Service {
    private final Set<Lab5SetElement> set = new LinkedHashSet<>();

    @Override
    public void solveLab5(Lab5DTO request) {
        String setString = request.getRequest();
        long start = System.currentTimeMillis();
        try {
            fillSet(setString);
            if (set.isEmpty()) {
                log.error(String.format(Lab5Constant.VERIFICATION_FAILED_MESSAGE, Lab5Constant.EMPTY_SET_MESSAGE));
            } else {
                log.info(Lab5Constant.VERIFICATION_PASSED_MESSAGE);
            }
        } catch (IllegalStateException exception) {
            log.error(String.format(Lab5Constant.VERIFICATION_FAILED_MESSAGE, exception.getMessage()));
        }
        long end = System.currentTimeMillis();
        log.info(String.format(CommonConstant.TIME_EXECUTION_MESSAGE, end - start));
        set.clear();
    }

    private void fillSet(String setString) {
        Pattern pattern = Pattern.compile(Lab5Constant.SET_ELEMENT_PATTERN);
        Matcher matcher = pattern.matcher(setString);
        while (matcher.find()) {
            String element = matcher.group();
            element = element.replaceAll(Lab5Constant.EXTRA_ELEMENTS_DELETION_REGEX, CommonConstant.VOID);
            List<String> colors = Arrays.stream(element.split(Lab5Constant.DIVIDER)).toList();
            if (colors.get(Lab5Constant.FIRST_ELEMENT_INDEX).equals(colors.get(Lab5Constant.SECOND_ELEMENT_INDEX))) {
                throw new IllegalStateException(Lab5Constant.SAME_COLORS_MESSAGE);
            }
            Lab5SetElement setElement = Lab5SetElement.builder()
                    .colors(colors)
                    .build();
            if (set.contains(setElement)) {
                throw new IllegalStateException(Lab5Constant.DUPLICATE_ELEMENT_MESSAGE);
            }
            set.add(setElement);
        }
    }
}
