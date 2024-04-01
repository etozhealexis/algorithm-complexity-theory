package ru.etozhealexis.algorithmcomplexitytheory.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab3DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab3.Lab3ServiceImpl;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab3ServiceTest {

    @InjectMocks
    private Lab3ServiceImpl lab3Service;

    @ParameterizedTest
    @MethodSource("provideStateSchemaArguments")
    void checkSolving(String stateSchema) {
        lab3Service.solveLab3(Lab3DTO.builder()
                .stateSchema(stateSchema)
                .build());
    }

    private static Stream<Arguments> provideStateSchemaArguments() {
        return Stream.of(
                Arguments.of("3\n1 0 1\n1 1 2\n2 0 2\n2 1 1\n1"),
                Arguments.of("3\n1 0 1\n1 1 2\n2 1 2\n2 1 2\n2"),
                Arguments.of("3\n1 0 1\n1 1 2\n2 0 2\n2 1 1\n1 2 3")
        );
    }
}
