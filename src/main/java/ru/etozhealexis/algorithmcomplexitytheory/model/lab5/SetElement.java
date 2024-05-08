package ru.etozhealexis.algorithmcomplexitytheory.model.lab5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class SetElement {
    private List<String> colors;
}
