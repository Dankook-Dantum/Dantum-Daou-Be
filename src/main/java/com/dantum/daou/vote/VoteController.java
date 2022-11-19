package com.dantum.daou.vote;


import com.dantum.daou.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final VoteService voteService;

    // 투표 리스트 조회
    @GetMapping("/votes/{userIdx}")
    public List<VoteResponseDto> findAll(){

        return voteService.findAll();
    }

    // 투표 상세 조회 api
    @GetMapping("/votes/details/{voteIdx}")
    public ResponseEntity<Object> findVote(@PathVariable(name = "voteIdx") Long voteIdx) throws CustomException {
        return voteService.showResponse(voteIdx);
    }

    @PostMapping("/votes/{userIdx}")  // 투표 생성
    public ResponseEntity<Object> createVote(@PathVariable(name = "userIdx") Long userIdx, @RequestBody VoteRequestDto requestDto){
        return voteService.createVote(userIdx, requestDto);
    }

    // 투표 삭제
    @DeleteMapping("/votes/{voteIdx}")
    public ResponseEntity<Object> deleteVote(@PathVariable(name = "voteIdx") Long voteIdx){
        return voteService.delete(voteIdx);
    }

}
