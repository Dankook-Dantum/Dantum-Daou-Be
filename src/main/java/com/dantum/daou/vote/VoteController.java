package com.dantum.daou.vote;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class VoteController {

    private final VoteService voteService;

    @PostMapping("/votes/{userIdx}")
    public Long createVote(@RequestBody VoteCreateRequestDto createRequestDto){
        return voteService.createVote(createRequestDto);
    }

}
