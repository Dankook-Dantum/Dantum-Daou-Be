package com.dantum.daou.vote;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Transactional // 투표 생성
    public Long createVote(VoteCreateRequestDto createRequestDto){
        return voteRepository.save(createRequestDto.toEntity()).getVoteIdx();
    }


    @Transactional(readOnly = true) // 투표 조회(예외처리 제외)
    public List<VoteResponseDto> searchAllDesc(){
        return voteRepository.findAll().stream()
                .map(VoteResponseDto::new)
                .collect(Collectors.toList());
    }
}