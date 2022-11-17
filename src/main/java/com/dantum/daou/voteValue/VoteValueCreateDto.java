package com.dantum.daou.voteValue;

import com.dantum.daou.vote.Vote;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteValueCreateDto {
    private int type;
    private Vote vote;

    @Builder
    public VoteValueCreateDto(VoteValueRequestDto requestDto, Vote vote) {
        this.type = requestDto.getType();
        this.vote = vote;
    }

    public VoteValue toEntity() {
        return VoteValue.builder()
                .type(type)
                .vote(vote).build();
    }
}
