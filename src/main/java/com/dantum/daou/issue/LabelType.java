package com.dantum.daou.issue;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@NoArgsConstructor
public enum LabelType {
    ISSUE("Issue", 0),
    INPROGRESS("In progress", 1),
    DONE("Done", 2);

    private String label;
    private int code;

    LabelType(String label, int code) {
        this.label = label;
        this.code = code;
    }

    private static final Map<Integer, String> BY_CODE_MAP_LABEL = Stream.of(values()).collect(Collectors.toMap(LabelType::getCode, LabelType::getLabel));
    public static String labelValueOfCode(int code) {
        return BY_CODE_MAP_LABEL.get(code);
    }
}
