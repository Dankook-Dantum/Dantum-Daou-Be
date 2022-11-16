package com.dantum.daou.issue;


import com.dantum.daou.user.User;
import com.dantum.daou.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    private final UserRepository userRepository;

    public ResponseEntity<Object> createIssue(Long userIdx, IssueRequestDto requestDto) {
        User user = userRepository.findById(userIdx).orElseThrow(NullPointerException::new);
        IssueCreateDto issueCreateDto = IssueCreateDto.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .label(requestDto.getLabel())
                .user(user)
                .build();
        Issue issue = issueCreateDto.toEntity();

        issueRepository.save(issue);

        return ResponseEntity.status(HttpStatus.CREATED).body("create success");
    }

        // 이슈 리스트 조회
        public List<IssueResponseDto> findAll () {
            return issueRepository.findAll().stream()
                    .map(IssueResponseDto::new)
                    .collect(Collectors.toList());

        }
    }

