package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class VoteResponseDto {
    private Long voteIdx;
    private String title;
    private String name;
    private LocalDateTime createdAt;

    @Builder
    public VoteResponseDto(Vote entity){
        this.voteIdx = entity.getVoteIdx();         // 투표 idx
        this.title = entity.getTitle();             // 투표 명(내용)
        this.name = entity.getUser().getName();     // 투표 작성자
        this.createdAt = entity.getCreatedAt();
    }
}
