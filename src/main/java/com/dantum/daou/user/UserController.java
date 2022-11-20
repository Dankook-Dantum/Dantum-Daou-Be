package com.dantum.daou.user;


import com.dantum.daou.exception.CustomException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userIdx}")
    @ApiOperation(value = "회원정보 조회 API", notes = "유저 인덱스를 받아 해당 유저의 회원 정보를 조회한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형으로 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원정보 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> getUser(@PathVariable("userIdx") Long userIdx) throws Exception {
        return userService.getUser(userIdx);
    }

    @GetMapping("/detail/{userIdx}")
    @ApiOperation(value = "회원정보 상세 조회 API", notes = "유저 인덱스를 받아 해당 유저의 회원 상세 정보를 조회한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형으로 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원 상세 정보 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> getDetailUser(@PathVariable("userIdx") Long userIdx) throws CustomException {
        return userService.getUserDetail(userIdx);
    }

    @PatchMapping("/{userIdx}")
    @ApiOperation(value = "회원정보 수정 API", notes = "유저 인덱스를 받아 해당 유저의 회원정보를 수정한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형으로 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "회원정보 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> updateUser(@PathVariable("userIdx") Long userIdx, @RequestBody UserRequestDto requestDto) throws Exception {
        return userService.updateUser(userIdx, requestDto);
    }

    // 유저 삭제
    @DeleteMapping("/{userIdx}")
    @ApiOperation(value = "회원정보 삭제 API", notes = "유저 인덱스를 받아 해당 유저의 회원정보를 삭제한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형으로 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 204, message = "유저 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "userIdx") Long userIdx){
        return userService.delete(userIdx);
    }

}
