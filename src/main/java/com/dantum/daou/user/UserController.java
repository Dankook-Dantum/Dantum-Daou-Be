package com.dantum.daou.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseBody
    @PatchMapping("/user/{idx}")
    public ResponseEntity<Object> updateUser(
            @PathVariable("idx") @Positive(message = "Please input positive number") @NotNull(message = "Please input param") @Validated Long idx,
            @RequestBody @Validated UserRequestDto request,
            Errors errors) throws Exception {

        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getField() + " - " + errors.getFieldError().getDefaultMessage();
            throw new IllegalArgumentException(errorMessage);
        }

        return userService.updateUser(idx, request);
    }

    @ResponseBody
    @GetMapping("/user/{idx}")
    public ResponseEntity<Object> getUser(
            @PathVariable("idx") @Positive(message = "Please input positive number") @NotNull(message = "Please input param") @Validated Long idx,
            Errors errors) {

        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getField() + " - " + errors.getFieldError().getDefaultMessage();
            throw new IllegalArgumentException(errorMessage);
        }

        return userService.getUser(idx);
    }

    @DeleteMapping("/users/{idx}")
    public ResponseEntity<Object> deleteUser(
            @PathVariable("idx") @Positive(message = "Please input positive number") @NotNull(message = "Please input param") @Validated Long idx,
            @RequestBody @Validated WithdrawalRequestDto request,
            Errors errors) {

        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getField() + " - " + errors.getFieldError().getDefaultMessage();
            throw new IllegalArgumentException(errorMessage);
        }

        return userService.deleteUser(idx, request);
    }
}
