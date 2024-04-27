package ru.etozhealexis.algorithmcomplexitytheory.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Lab4Constant {
    public static final String REPLACE_PATTERN = "[^a-z]";
    public static final String SUITABLE_FORMULA_MESSAGE = "Formula \"%s\" is in cnf and has maximum two duplicates of each variable";
    public static final String NOT_IN_CNF_MESSAGE = "Formula \"%s\" is not in CNF";
    public static final String TOO_MANY_DUPLICATES_MESSAGE = "Formula \"%s\" has too many duplicates";
    public static final String TIME_EXECUTION_MESSAGE = "Execution time: %sms";
    public static final Integer ONE = 1;
    public static final Integer MAX_DUPLICATES = 2;
}
