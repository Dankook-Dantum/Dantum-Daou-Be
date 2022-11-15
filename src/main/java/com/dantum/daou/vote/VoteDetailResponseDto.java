package com.dantum.daou.vote;

public class VoteDetailResponseDto {
    private Long voteIdx;
    private String title;

    private String name;

    private int type;


    public VoteDetailResponseDto(VoteValue entity){
        this.voteIdx = entity.getVote().getVoteIdx();         // 투표 idx
        this.title = entity.getVote().getTitle();             // 투표 명(내용)
        this.name = entity.getVote().getUser().getName();     // 투표 작성자
        this.type = entity.getType();
    }
}
