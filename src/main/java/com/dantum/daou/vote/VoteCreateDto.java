package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteCreateDto {
    private String title;
    private User user;

    @Builder
    public VoteCreateDto(String title, User user){ // 리팩토링 예정 : 작성일 추가
        this.title = title;
        this.user = user;
    }

    public Vote toEntity(){
        return Vote.builder()
                .title(title)
                .user(user)
                .build();
    }


}
