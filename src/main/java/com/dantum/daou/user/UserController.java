package com.dantum.daou.user;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @ApiOperation(value="회원정보 조회")
    @GetMapping("/{userIdx}")
    public ResponseEntity<Object> getUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUser(userIdx);
    }

    @ApiOperation(value="회원정보 상세 조회")
    @GetMapping("/detail/{userIdx}")
    public ResponseEntity<Object> getDetailUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUserDetail(userIdx);
    }

    @PatchMapping("/{userIdx}")
    public ResponseEntity<Object> updateUser(@PathVariable("userIdx") Long userIdx, @RequestBody UserRequestDto requestDto) {
        return userService.updateUser(userIdx, requestDto);
    }

}
