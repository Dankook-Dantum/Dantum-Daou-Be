package com.dantum.daou.vote;


import lombok.Getter;

@Getter
public class VoteResponseDto {

    private Long voteIdx;
    private String title;


    public VoteResponseDto(Vote entity){
        this.voteIdx = entity.getVoteIdx();
        this.title = entity.getTitle();
    }
}
