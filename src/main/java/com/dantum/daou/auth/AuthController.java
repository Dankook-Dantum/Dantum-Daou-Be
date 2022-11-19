package com.dantum.daou.auth;

import com.dantum.daou.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody UserRequestDto requestDto) throws Exception {
        return authService.signUp(requestDto);
    }
}
