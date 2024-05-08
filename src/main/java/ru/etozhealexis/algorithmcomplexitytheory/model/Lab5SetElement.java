package ru.etozhealexis.algorithmcomplexitytheory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class Lab5SetElement {
    private List<String> colors;
}
