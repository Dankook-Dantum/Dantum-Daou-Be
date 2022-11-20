package com.dantum.daou.issue;


import com.dantum.daou.exception.CustomException;
import com.dantum.daou.exception.ResourceNotFoundException;
import com.dantum.daou.user.User;
import com.dantum.daou.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.dantum.daou.exception.ErrorCode.NOT_EXIST_ISSUE;


@Transactional
@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    private final UserRepository userRepository;

    // 이슈 생성
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
    public List<IssueResponseDto> findAll () throws CustomException {

        List<IssueResponseDto> issueList = issueRepository.findAll().stream()
                .map(IssueResponseDto::new)
                .collect(Collectors.toList());

        if (issueList.size() == 0) {  // 이슈가 없다면
            throw new CustomException(NOT_EXIST_ISSUE);
        } else {
            return issueList;
        }
    }

    // 이슈 삭제
    public ResponseEntity<Object> delete(Long id){
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Issue", "id",id));
        issueRepository.delete(issue);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete success");
    }

    public ResponseEntity<Object> updateIssue(Long issueIdx, IssueRequestDto requestDto) throws CustomException {
        Issue issue = issueRepository.findById(issueIdx).orElse(null);

        if (issue == null) {  // 이슈가 없다면
            throw new CustomException(NOT_EXIST_ISSUE);
        }
        else {
            issue.update(requestDto);
            issueRepository.save(issue);
            return ResponseEntity.status(HttpStatus.OK).body("Update success");
        }
    }
}

