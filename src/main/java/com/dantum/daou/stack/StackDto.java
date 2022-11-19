package com.dantum.daou.stack;

import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StackDto {
    private String stack;

    @Builder
    public StackDto(String stack) {
        this.stack = stack;
    }
}
