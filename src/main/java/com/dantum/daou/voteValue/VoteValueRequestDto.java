package com.dantum.daou.voteValue;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteValueRequestDto {
    private Long voteIdx;
    private int type;

    @Builder
    public VoteValueRequestDto(Long voteIdx, int type) {
        this.voteIdx = voteIdx;
        this.type = type;
    }
}
