package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteCreateRequestDto {

    private User user;
    private String title;



    @Builder
    public VoteCreateRequestDto(User user, String title){ // 리팩토링 예정 : 작성일 추가
        this.user = user;
        this.title = title;

    }

    public Vote toEntity(){
        return Vote.builder()
                .user(user)
                .title(title)
                .build();
    }


}
