package com.dantum.daou.auth;

import com.dantum.daou.exception.DuplicateException;
import com.dantum.daou.user.User;
import com.dantum.daou.user.UserCreateDto;
import com.dantum.daou.user.UserRepository;
import com.dantum.daou.user.UserRequestDto;
import com.dantum.daou.util.AesEncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final AesEncryptUtil aesEncryptUtil;

    @Transactional
    public ResponseEntity<Object> signUp(UserRequestDto requestDto) throws Exception {
        String encrytEmail = aesEncryptUtil.encryptAES256(requestDto.getEmail());
        boolean isExist = userRepository.existsByEmail(encrytEmail);

        if (isExist) throw new DuplicateException("User", "email", requestDto.getEmail());

        UserCreateDto userCreateDto = UserCreateDto.builder()
                .requestDto(requestDto)
                .aesEncryptUtil(aesEncryptUtil).build();
        User user = userCreateDto.toEntity();

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Create User Success");
    }

}
