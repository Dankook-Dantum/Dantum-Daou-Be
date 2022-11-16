package com.dantum.daou.user;

import com.dantum.daou.stack.Stack;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserDetailDto {
    private String office;
    private String introduce;
    private String mbti;
    private List<Stack> stacks = new ArrayList<>();

    @Builder
    public UserDetailDto(User user) {
        this.office = user.getOffice();
        this.introduce = user.getIntroduce();
        this.mbti = user.getMbti();
        this.stacks = user.getStacks();
    }
}
