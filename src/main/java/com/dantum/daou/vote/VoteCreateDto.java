package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteCreateDto {

    private Long userIdx;
    private String title;



    @Builder
    public VoteCreateDto(Long userIdx, String title){ // 리팩토링 예정 : 작성일 추가
        this.userIdx = userIdx;
        this.title = title;

    }

    public Vote toEntity(){
        return Vote.builder()
                .user(userIdx)
                .title(title)
                .build();
    }


}
