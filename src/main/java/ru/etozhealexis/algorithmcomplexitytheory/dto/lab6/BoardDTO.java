package ru.etozhealexis.algorithmcomplexitytheory.dto.lab6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private String[] board;
}
