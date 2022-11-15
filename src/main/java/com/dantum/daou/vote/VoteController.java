package com.dantum.daou.vote;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoteController {

    private final VoteService voteService;


    @GetMapping("/votes/{userIdx}") // 투표 리스트 조회
    public List<VoteResponseDto> findAll(){
        return voteService.findAll();
    }

    // 투표 상세 조회 api
    @GetMapping("/votes/details/{voteIdx}")
    public Vote findVote(@PathVariable("voteIdx") Long voteIdx){
        return voteService.findVote(voteIdx);
    }



    @PostMapping("/votes/{userIdx}")  // 투표 생성
    public Long createVote(@RequestBody VoteCreateRequestDto createRequestDto){
        return voteService.createVote(createRequestDto);
    }

}
