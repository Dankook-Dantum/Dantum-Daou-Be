package com.dantum.daou.user;

import com.dantum.daou.exception.ResourceNotFoundException;
import com.dantum.daou.issue.Issue;
import com.dantum.daou.issue.IssueRepository;
import com.dantum.daou.stack.Stack;
import com.dantum.daou.stack.StackRepository;
import com.dantum.daou.vote.Vote;
import com.dantum.daou.vote.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final StackRepository stackRepository;

    private final IssueRepository issueRepository;

    private final VoteRepository voteRepository;

    public ResponseEntity<Object> getUser(Long userIdx) {
        User user = findById(userIdx);

        UserDto userDto = UserDto.builder()
                .user(user).build();

        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    public ResponseEntity<Object> getUserDetail(Long userIdx) {
        User user = findById(userIdx);

        UserDetailDto userDetailDto = UserDetailDto.builder()
                .user(user).build();

        return ResponseEntity.status(HttpStatus.OK).body(userDetailDto);
    }

    public ResponseEntity<Object> updateUser(Long userIdx, UserRequestDto requestDto) {
        User user = findById(userIdx);

        UserUpdateDto userUpdateDto = UserUpdateDto.builder()
                .requestDto(requestDto).build();

        user.update(userUpdateDto);

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body("Update success");
    }

    public User findById(Long userIdx) {
        return userRepository.findById(userIdx).orElseThrow(NullPointerException::new);
    }

    // 유저 삭제
    public ResponseEntity<Object> delete(Long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id",id));

        // User 외래키 관련 Entity 삭제
        List<Stack> stackList = user.getStacks();
        List<Issue> issueList = user.getIssues();
        List<Vote> voteList = user.getVotes();

        stackRepository.deleteAll(stackList);
        issueRepository.deleteAll(issueList);
        voteRepository.deleteAll(voteList);

        // User 삭제
        userRepository.delete(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("delete success");
    }


}
