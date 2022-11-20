package com.dantum.daou.auth;

import com.dantum.daou.user.UserRequestDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "회원가입 API", notes = "Request body를 받아 회원 정보를 저장한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "회원가입 성공"),
            @ApiResponse(code = 400, message = "잘못된 회원정보 입력"),
            @ApiResponse(code = 409, message = "중복 회원가입"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> signUp(@RequestBody UserRequestDto requestDto) throws Exception {
        return authService.signUp(requestDto);
    }
}
