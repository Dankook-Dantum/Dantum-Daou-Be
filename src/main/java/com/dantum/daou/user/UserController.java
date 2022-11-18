package com.dantum.daou.user;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value="회원정보 조회")
    @GetMapping("/users/{userIdx}")
    public ResponseEntity<Object> getUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUser(userIdx);
    }

    @ApiOperation(value="회원정보 상세 조회")
    @GetMapping("/users/detail/{userIdx}")
    public ResponseEntity<Object> getDetailUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUserDetail(userIdx);
    }

}
