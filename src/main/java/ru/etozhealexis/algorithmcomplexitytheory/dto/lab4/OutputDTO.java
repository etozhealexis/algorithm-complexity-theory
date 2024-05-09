package ru.etozhealexis.algorithmcomplexitytheory.dto.lab4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OutputDTO {
    private String message;
    private String timeExecutionMessage;
}
