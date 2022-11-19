package com.dantum.daou.voteValue;

import com.dantum.daou.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VoteValueController {
    private final VoteValueService voteValueService;

    @PostMapping("/votes/values")
    public ResponseEntity<Object> createVoteValue(@RequestBody VoteValueRequestDto requestDto) {
        return voteValueService.createVoteValue(requestDto);
    }

    @GetMapping("/votes/values/{voteIdx}")
    public ResponseEntity<Object> getVoteResult(@PathVariable Long voteIdx) throws CustomException {
        return voteValueService.getVoteResult(voteIdx);
    }
}
