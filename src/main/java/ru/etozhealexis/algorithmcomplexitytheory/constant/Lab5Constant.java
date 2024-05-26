package ru.etozhealexis.algorithmcomplexitytheory.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Lab5Constant {
    public static final String VERIFICATION_PASSED_MESSAGE = "Verification passed.";
    public static final String VERIFICATION_FAILED_MESSAGE = "Verification failed.";
    public static final String SAME_COLORS_MESSAGE = "Same colors in one element";
    public static final String DUPLICATE_ELEMENT_MESSAGE = "The element is already in set";
    public static final String EMPTY_SET_MESSAGE = "The set is empty";
    public static final String SET_ELEMENT_PATTERN = "\\{[\\d, ]*\\}";
    public static final String EXTRA_ELEMENTS_DELETION_REGEX = "[^\\d,]";
    public static final String DIVIDER = " ";
    public static final int FIRST_ELEMENT_INDEX = 0;
    public static final int SECOND_ELEMENT_INDEX = 1;
}
