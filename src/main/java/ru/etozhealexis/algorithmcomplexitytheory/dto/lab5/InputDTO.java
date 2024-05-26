package ru.etozhealexis.algorithmcomplexitytheory.dto.lab5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class InputDTO {
    private String s;
    private String c;
    private String chi;
}
