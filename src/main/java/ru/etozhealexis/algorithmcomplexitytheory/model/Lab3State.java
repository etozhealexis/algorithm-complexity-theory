package ru.etozhealexis.algorithmcomplexitytheory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "status")
@Getter
@ToString
public final class Lab3State {
    private final Character name;
    private final Lab3StateStatus status;

    public enum Lab3StateStatus {
        ACCEPT,
        DENY
    }
}
