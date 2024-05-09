package ru.etozhealexis.algorithmcomplexitytheory.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab2.Lab2ServiceImpl;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab2ServiceTest {

    @InjectMocks
    private Lab2ServiceImpl lab2Service;

    @ParameterizedTest
    @MethodSource("provideWordArguments")
    void checkStateMachineSolving(String request) {
        lab2Service.solveLab2WithStateMachine(LabInputDTO.builder()
                .request(request)
                .build());
        lab2Service.clearStack();
    }

    @ParameterizedTest
    @MethodSource("provideWordArguments")
    void checkRegexSolving(String word) {
        lab2Service.solveLab2WithRegex(LabInputDTO.builder()
                .request(word)
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
                Arguments.of("000000"),
                Arguments.of("001"),
                Arguments.of("0011"),
                Arguments.of("00011"),
                Arguments.of("000011"),
                Arguments.of("100")
        );
    }
}
