package com.dantum.daou.vote;

import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteRequestDto {
    private String title;

    @Builder
    public VoteRequestDto(String title){
        this.title = title;
    }
}
