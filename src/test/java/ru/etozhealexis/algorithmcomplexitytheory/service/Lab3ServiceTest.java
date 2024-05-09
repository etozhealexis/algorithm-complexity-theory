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
import ru.etozhealexis.algorithmcomplexitytheory.service.lab3.Lab3ServiceImpl;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class Lab3ServiceTest {

    @InjectMocks
    private Lab3ServiceImpl lab3Service;

    @ParameterizedTest
    @MethodSource("provideStateSchemaArguments")
    void checkSolving(String request) {
        lab3Service.solveLab3(LabInputDTO.builder()
                .request(request)
                .build());
        lab3Service.clearGraph();
    }

    private static Stream<Arguments> provideStateSchemaArguments() {
        return Stream.of(
                Arguments.of("3n1 0 1n1 1 2n2 0 2n2 1 1n1"),
                Arguments.of("3n1 0 1n1 1 2n2 1 2n2 1 2n2"),
                Arguments.of("3n1 0 1n1 1 2n2 0 2n2 1 1n1 2 3"),
                Arguments.of("4n1 0 4n1 1 2n2 0 4n2 1 3n3 0 4n3 1 4n4 0 4n4 1 4n3")
        );
    }
}
