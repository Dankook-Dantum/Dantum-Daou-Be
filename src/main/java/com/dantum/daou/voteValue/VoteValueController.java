package com.dantum.daou.voteValue;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VoteValueController {
    private final VoteValueService voteValueService;

    @PostMapping("/votes/values")
    public ResponseEntity<Object> createVoteValue(@RequestBody VoteValueRequestDto requestDto) {
        return voteValueService.createVoteValue(requestDto);
    }
}
