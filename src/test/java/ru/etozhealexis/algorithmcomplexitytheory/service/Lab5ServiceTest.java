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
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
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
    void checkSolving(String request) {
        when(pattern.matcher(request)).thenReturn(Pattern.compile("\\([A-Za-z, ]*\\)").matcher(request));
        lab5Service.solveLab5(LabInputDTO.builder()
                .request(request)
                .build());
    }

    private static Stream<Arguments> provideSetArguments() {
        return Stream.of(
                Arguments.of("s = {(red, blue), (red, red), (white, yellow)}"),
                Arguments.of("s = {(red, blue), (red, blue), (white, yellow)}"),
                Arguments.of("s = {}")
        );
    }
}
