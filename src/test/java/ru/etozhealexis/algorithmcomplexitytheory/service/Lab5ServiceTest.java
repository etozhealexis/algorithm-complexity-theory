package ru.etozhealexis.algorithmcomplexitytheory.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab5DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab5.Lab5ServiceImpl;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab5ServiceTest {

    @InjectMocks
    private Lab5ServiceImpl lab5Service;

    @ParameterizedTest
    @MethodSource("provideStateSchemaArguments")
    void checkSolving(String formula) {
        lab5Service.solveLab5(Lab5DTO.builder()
                .request(formula)
                .build());
    }

    private static Stream<Arguments> provideStateSchemaArguments() {
        return Stream.of(
                Arguments.of("s = {(red, blue), (red, red), (white, yellow)}"),
                Arguments.of("s = {(red, blue), (red, blue), (white, yellow)}"),
                Arguments.of("s = {}")
        );
    }
}
