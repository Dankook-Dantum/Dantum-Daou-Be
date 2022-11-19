package com.dantum.daou.issue;


import com.dantum.daou.exception.CustomException;
import com.dantum.daou.vote.VoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("issues")
public class IssueController {

    private final IssueService issueService;

    // 이슈 리스트 조회
    @GetMapping("/{userIdx}")
    public List<IssueResponseDto> findAll() throws CustomException {
        return issueService.findAll();
    }

    // 이슈 생성 api
    @PostMapping("/{userIdx}")
    public ResponseEntity<Object> createIssue(@PathVariable(name = "userIdx") Long userIdx, @RequestBody IssueRequestDto requestDto){
        return issueService.createIssue(userIdx, requestDto);
    }

    // 이슈 삭제
    @DeleteMapping("/{issueIdx}")
    public ResponseEntity<Object> deleteIssue(@PathVariable(name = "issueIdx") Long issueIdx){
        return issueService.delete(issueIdx);
    }

    @PatchMapping("/{issueIdx}")
    public ResponseEntity<Object> updateIssue(
            @PathVariable(name = "issueIdx") Long issueIdx,
            @RequestBody IssueRequestDto requestDto) throws CustomException {
        return issueService.updateIssue( issueIdx,requestDto);
    }

}
