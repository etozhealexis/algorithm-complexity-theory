package ru.etozhealexis.algorithmcomplexitytheory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab1Constant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab5Constant;

import java.util.regex.Pattern;

@Configuration
public class LabConfig {

    @Bean(name = "lab1Pattern")
    public Pattern getLab1Pattern() {
        return Pattern.compile(Lab1Constant.WORD_REGEX);
    }

    @Bean(name = "lab5Pattern")
    public Pattern getLab5Pattern() {
        return Pattern.compile(Lab5Constant.SET_ELEMENT_PATTERN);
    }
}
