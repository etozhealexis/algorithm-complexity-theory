package ru.etozhealexis.algorithmcomplexitytheory.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Lab1Constant {
    public static final int MIN_WRONG_WORD_LENGTH = 2;
    public static final int MAX_WRONG_WORD_LENGTH = 3;
    public static final String WORD_REGEX = "1{2,3}";
    public static final String SUITABLE_WORD_MESSAGE = "\"%s\" is a suitable word";
    public static final String NOT_SUITABLE_WORD_MESSAGE = "\"%s\" is not a suitable word";
    public static final String ILLEGAL_STATE_MESSAGE = "Unexpected value: \"%s\"";
    public static final char ZERO = '0';
}
