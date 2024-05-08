package ru.etozhealexis.algorithmcomplexitytheory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Lab6BoardDTO {
    private String[] board;
}
