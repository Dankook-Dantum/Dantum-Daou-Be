package com.dantum.daou.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{userIdx}")
    public ResponseEntity<Object> getUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUser(userIdx);
    }

    @GetMapping("/users/detail/{userIdx}")
    public ResponseEntity<Object> getDetailUser(@PathVariable("userIdx") Long userIdx) {
        return userService.getUserDetail(userIdx);
    }

}
