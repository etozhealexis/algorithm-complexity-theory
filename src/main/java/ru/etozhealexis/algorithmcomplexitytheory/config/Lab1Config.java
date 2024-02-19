package ru.etozhealexis.algorithmcomplexitytheory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab1Constant;

import java.util.regex.Pattern;

@Configuration
public class Lab1Config {

    @Bean
    public Pattern getPattern() {
        return Pattern.compile(Lab1Constant.WORD_REGEX);
    }
}
