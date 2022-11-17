package com.dantum.daou.voteValue;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class VoteValueResponseDto {
    private int likeCount;
    private int dislikeCount;
    @Builder
    public VoteValueResponseDto(List<VoteValue> voteValueList) {
        this.likeCount = voteValueList.stream()
                .filter(voteValue -> (voteValue.getType() == VoteValueTypeEnum.LIKE.getCode()))
                .collect(Collectors.toList()).size();
        this.dislikeCount = voteValueList.stream()
                .filter(voteValue -> (voteValue.getType() == VoteValueTypeEnum.DISLIKE.getCode()))
                .collect(Collectors.toList()).size();
    }
}
