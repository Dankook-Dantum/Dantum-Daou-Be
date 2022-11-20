package com.dantum.daou.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@NoArgsConstructor
public class UserDetailDto {
    private String office;
    private String introduce;
    private String mbti;
    private String stacks;

    @Builder
    public UserDetailDto(User user) {
        StringBuilder stringBuilder = new StringBuilder();
        user.getStacks().stream()
                .forEach(stack -> {
                    stringBuilder.append(stack.getStack()).append(" / ");
                });
        String stackReulst = stringBuilder.toString();
        this.office = user.getOffice();
        this.introduce = user.getIntroduce();
        this.mbti = user.getMbti();
        this.stacks = stackReulst.substring(0, stackReulst.length() - 3);
    }
}
