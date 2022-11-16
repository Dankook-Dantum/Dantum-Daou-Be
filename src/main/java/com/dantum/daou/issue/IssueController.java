package com.dantum.daou.issue;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("issues")
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/{userIdx}")
    public List<IssueResponseDto> findAll(){
        return issueService.findAll();
    }
}
