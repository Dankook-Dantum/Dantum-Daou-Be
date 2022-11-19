package com.dantum.daou.stack;

import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StackCreateDto {
    private String stack;
    private User user;

    @Builder
    public StackCreateDto(String stack, User user) {
        this.stack = stack;
        this.user = user;
    }

    public Stack toEntity() {
        return Stack.builder()
                .stack(stack)
                .user(user).build();
    }
}
