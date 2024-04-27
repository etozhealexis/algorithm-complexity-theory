package ru.etozhealexis.algorithmcomplexitytheory.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab4DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab4.Lab4ServiceImpl;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab4ServiceTest {

    @InjectMocks
    private Lab4ServiceImpl lab4Service;

    @ParameterizedTest
    @MethodSource("provideStateSchemaArguments")
    void checkSolving(String formula) {
        lab4Service.solveLab4(Lab4DTO.builder()
                .request(formula)
                .build());
    }

    private static Stream<Arguments> provideStateSchemaArguments() {
        return Stream.of(
                Arguments.of("((a | c) & (b | c) & (a | !d) & (b | !d))"),
                Arguments.of("(!(b | c))"),
                Arguments.of("(a & b)"),
                Arguments.of("(!a & (b | c))"),
                Arguments.of("(a & b | c)"),
                Arguments.of("(a & (b | (d & e)))")
        );
    }
}
