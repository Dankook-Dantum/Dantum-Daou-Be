package com.dantum.daou.issue;


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
    public List<IssueResponseDto> findAll(){
        return issueService.findAll();
    }


    @PostMapping("/{userIdx}")
    public ResponseEntity<Object> createIssue(@PathVariable(name = "userIdx") Long userIdx, @RequestBody IssueRequestDto requestDto){
        return issueService.createIssue(userIdx, requestDto);
    }


}
