package com.dantum.daou.stack;

import com.dantum.daou.exception.DuplicateException;
import com.dantum.daou.exception.ResourceNotFoundException;
import com.dantum.daou.issue.Issue;
import com.dantum.daou.user.User;
import com.dantum.daou.user.UserService;
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
public class StackService {
    private final StackRepository stackRepository;
    private final UserService userService;

    public List<Stack> findByUser(Long userIdx) {
        User user = userService.findById(userIdx);

        return stackRepository.findAllByUser(user);
    }


    public ResponseEntity<Object> getStack(Long userIdx) {
        List<Stack> stackList = findByUser(userIdx);
        List<StackDto> stackDtoList = stackList.stream()
                .map(stack ->  {
                    return StackDto.builder()
                            .stack(stack.getStack()).build();
                }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(stackDtoList);
    }


    public ResponseEntity<Object> createStack(Long userIdx, StackDto stackDto) {
        boolean isExist = stackRepository.existsByStack(stackDto.getStack());

        if (isExist) {
            throw new DuplicateException("Stack", "stack", stackDto.getStack());

        }

        User user = userService.findById(userIdx);
        StackCreateDto stackCreateDto = StackCreateDto.builder()
                .stack(stackDto.getStack())
                .user(user).build();
        Stack stack = stackCreateDto.toEntity();

        stackRepository.save(stack);

        return ResponseEntity.status(HttpStatus.CREATED).body("Create Success");
    }

/*    @Transactional
    public ResponseEntity<Object> updateStack(Long userIdx, StackDto stackDto) {

    }*/

// 스택 삭제
public ResponseEntity<Object> delete(Long id){
    Stack stack = stackRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Stack", "id",id));
    stackRepository.delete(stack);

    return ResponseEntity.status(HttpStatus.CREATED).body("delete success");
}

}
