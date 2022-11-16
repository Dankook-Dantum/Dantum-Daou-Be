package com.dantum.daou.issue;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;


    public List<IssueResponseDto> findAll(){
        return issueRepository.findAll().stream()
                .map(IssueResponseDto::new)
                .collect(Collectors.toList());

    }
}
