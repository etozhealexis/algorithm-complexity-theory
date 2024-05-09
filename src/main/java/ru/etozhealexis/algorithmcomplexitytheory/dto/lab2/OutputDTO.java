package ru.etozhealexis.algorithmcomplexitytheory.dto.lab2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OutputDTO {
    private String stateHistoryMessage;
    private String stackElementsMessage;
    private String message;
}
