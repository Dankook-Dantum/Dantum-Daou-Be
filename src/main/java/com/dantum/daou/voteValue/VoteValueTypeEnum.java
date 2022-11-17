package com.dantum.daou.voteValue;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum VoteValueTypeEnum {
    LIKE("Like", 0),
    DISLIKE("Dislike", 1);

    private String type;
    private int code;

    VoteValueTypeEnum(String type, int code) {
        this.type = type;
        this.code = code;
    }
}
