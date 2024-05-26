package ru.etozhealexis.algorithmcomplexitytheory.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab5.InputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab5.Lab5ServiceImpl;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab5ServiceTest {

    @InjectMocks
    private Lab5ServiceImpl lab5Service;

    @Mock
    @Qualifier("lab5Pattern")
    private Pattern pattern;

    @ParameterizedTest
    @MethodSource("provideSetArguments")
    void checkSolving(String s, String c, String chi) {
        when(pattern.matcher(c)).thenReturn(Pattern.compile("\\{[\\d, ]*}").matcher(c));
        lab5Service.solveLab5(InputDTO.builder()
                .s(s)
                .c(c)
                .chi(chi)
                .build());
        lab5Service.clearMap();
    }

    private static Stream<Arguments> provideSetArguments() {
        return Stream.of(
                Arguments.of("[1, 2, 3, 4]", "[{1, 2}, {2, 3}, {3, 4}]", "[0, 1, 0, 1]"),
                Arguments.of("[1, 2, 3, 4]", "[{1, 2}, {2, 3}, {3, 3}]", "[0, 1, 0, 1]"),
                Arguments.of("[1, 2, 3, 4]", "[{1, 2, 3, 4}, {1, 2, 4}, {1, 4}]", "[0, 1, 0, 1]"),
                Arguments.of("[1, 2, 3, 4]", "[{1, 2, 3, 4}, {2, 4}, {1, 4}]", "[0, 1, 0, 1]")
        );
    }
}
