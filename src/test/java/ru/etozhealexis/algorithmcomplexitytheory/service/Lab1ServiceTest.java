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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.etozhealexis.algorithmcomplexitytheory.config.LabConfig;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab1.Lab1ServiceImpl;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab1ServiceTest {

    @InjectMocks
    private Lab1ServiceImpl lab1Service;

    @Mock
    @Qualifier("lab1Pattern")
    private Pattern pattern;

    @ParameterizedTest
    @MethodSource("provideWordArguments")
    void checkStateMachineSolving(String word) {
        lab1Service.solveLab1WithStateMachine(LabInputDTO.builder()
                .request(word)
                .build());
    }

    @ParameterizedTest
    @MethodSource("provideWordArguments")
    void checkRegexSolving(String request) {
        when(pattern.matcher(request)).thenReturn(Pattern.compile("1{2,3}").matcher(request));
        lab1Service.solveLab1WithRegex(LabInputDTO.builder()
                .request(request)
                .build());
    }

    private static Stream<Arguments> provideWordArguments() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("1"),
                Arguments.of("11"),
                Arguments.of("111"),
                Arguments.of("1111"),
                Arguments.of("11111"),
                Arguments.of("111111"),
                Arguments.of("101010"),
                Arguments.of("10"),
                Arguments.of("101"),
                Arguments.of("1010"),
                Arguments.of("10101"),
                Arguments.of("0"),
                Arguments.of("01"),
                Arguments.of("010"),
                Arguments.of("0101"),
                Arguments.of("01010"),
                Arguments.of("010101"),
                Arguments.of("00"),
                Arguments.of("000"),
                Arguments.of("0000"),
                Arguments.of("00000"),
                Arguments.of("000000")
        );
    }
}
