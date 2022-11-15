package com.dantum.daou.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<Object> getUser(Long userIdx) {
        User user = userRepository.findById(userIdx).orElseThrow(NullPointerException::new);

        UserDto userDto = UserDto.builder()
                .user(user).build();

        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }


}
