package com.dantum.daou.stack;

import com.dantum.daou.exception.CustomException;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("stacks")
public class StackController {
    private final StackService stackService;

    @GetMapping("/{userIdx}")
    @ApiOperation(value = "스택 조회 API", notes = "유저 인덱스를 받아 해당 유저의 스택 목록 정보를 조회한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "스택 목록 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저가 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> getStacks(@PathVariable("userIdx") Long userIdx) {
        return stackService.getStack(userIdx);
    }

    @PostMapping("/{userIdx}")
    @ApiOperation(value = "스택 생성 API", notes = "유저 인덱스를 받아 해당 유저의 스택 정보를 저장한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 201, message = "스택 생성 성공"),
            @ApiResponse(code = 400, message = "잘못된 스택 정보 입력"),
            @ApiResponse(code = 409, message = "동일한 스택 정보 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> createStack(@PathVariable("userIdx") Long userIdx, @RequestBody StackDto stackDto) {
        return stackService.createStack(userIdx, stackDto);
    }

    @PatchMapping("/{userIdx}")
    @ApiOperation(value = "스택 수정 API", notes = "유저 인덱스를 받아 해당 유저의 스택을 수정한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "stackIdx", value = "스택 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "스택 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 스택 정보 입력"),
            @ApiResponse(code = 409, message = "동일한 스택 정보 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> updateStack(
            @PathVariable("userIdx") Long userIdx,
            @RequestParam("stackIdx") Long stackIdx,
            @RequestBody StackDto stackDto) throws CustomException {
        return stackService.updateStack(userIdx, stackIdx, stackDto);
    }

    // stack 삭제
    @DeleteMapping("/{stackIdx}")
    @ApiOperation(value = "스택 삭제 API", notes = "스택 인덱스를 받아 해당 스택을 삭제한다.")
    @ApiImplicitParam(name = "stackIdx", value = "스택 인덱스로 int형으로 양의 정수만 받는다", example = "1", dataType = "int", paramType = "query")
    @ApiResponses({
            @ApiResponse(code = 204, message = "스택 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 스택 인덱스 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> deleteStack(@PathVariable(name = "stackIdx") Long stackIdx){
        return stackService.delete(stackIdx);
    }
}
