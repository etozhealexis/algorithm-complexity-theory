package ru.etozhealexis.algorithmcomplexitytheory.service.lab5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab5Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.InputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.OutputDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Slf4j
@Service
public class Lab5ServiceImpl implements Lab5Service {

    private final Pattern pattern;
    private final HashMap<Integer, Integer> colorMap;

    @Autowired
    public Lab5ServiceImpl(@Qualifier("lab5Pattern") Pattern pattern) {
        this.pattern = pattern;
        this.colorMap = new HashMap<>();
    }

    @Override
    public OutputDTO solveLab5(InputDTO request) {
        long start = System.currentTimeMillis();
        List<Integer> elements =
                Arrays.stream(request.getS()
                                .replaceAll(Lab5Constant.EXTRA_ELEMENTS_DELETION_REGEX, CommonConstant.VOID)
                                .split(CommonConstant.COMMA))
                        .map(Integer::parseInt)
                        .toList();
        List<String> colors = getColors(request.getC());
        List<Integer> colorings =
                Arrays.stream(request.getChi()
                                .replaceAll(Lab5Constant.EXTRA_ELEMENTS_DELETION_REGEX, CommonConstant.VOID)
                                .split(CommonConstant.COMMA))
                        .map(Integer::parseInt)
                        .toList();
        log.info(elements.toString());
        log.info(colors.toString());
        log.info(colorings.toString());
        fillMap(elements, colorings);

        boolean noMonochromeElements = checkColors(colors);
        long end = System.currentTimeMillis();
        String message;
        if (noMonochromeElements) {
            message = Lab5Constant.VERIFICATION_PASSED_MESSAGE;
            log.info(message);
        } else {
            message = Lab5Constant.VERIFICATION_FAILED_MESSAGE;
            log.error(message);
        }
        String timeExecutionMessage = String.format(CommonConstant.TIME_EXECUTION_MESSAGE, end - start);
        log.info(timeExecutionMessage);

        return OutputDTO.builder()
                .message(message)
                .timeExecutionMessage(timeExecutionMessage)
                .build();
    }

    @Override
    public void clearMap() {
        colorMap.clear();
    }

    private List<String> getColors(String c) {
        List<String> colors = new ArrayList<>();
        Matcher matcher = pattern.matcher(c);
        while (matcher.find()) {
            colors.add(matcher.group());
        }
        return colors;
    }

    private void fillMap(List<Integer> elements, List<Integer> colorings) {
        IntStream.range(0, elements.size()).forEach(i -> colorMap.put(elements.get(i), colorings.get(i)));
    }

    private boolean checkColors(List<String> colors) {
        for (String color : colors) {
            List<Integer> subColors =
                    Arrays.stream(color.replaceAll(Lab5Constant.EXTRA_ELEMENTS_DELETION_REGEX, CommonConstant.VOID)
                                    .split(CommonConstant.COMMA))
                            .map(Integer::parseInt)
                            .toList();
            if (subColors.size() == 1) {
                return false;
            }
            int firstSubColor = colorMap.get(subColors.get(0));
            int monochromeElements = 1;
            for (int i = 1; i < subColors.size(); i++) {
                if (firstSubColor == colorMap.get(subColors.get(i))) {
                    monochromeElements++;
                }
            }
            if (monochromeElements == subColors.size()) {
                return false;
            }
        }
        return true;
    }
}
