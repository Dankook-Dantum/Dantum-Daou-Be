package com.dantum.daou.issue;


import com.dantum.daou.exception.CustomException;
import com.dantum.daou.vote.VoteRequestDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("issues")
public class IssueController {

    private final IssueService issueService;

    // 이슈 리스트 조회
    @GetMapping("/{userIdx}")
    @ApiOperation(value = "이슈 목록 조회 API", notes = "유저 인덱스를 받아 해당 유저의 이슈 목록을 조회한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "이슈 목록 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 이슈 인덱스 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public List<IssueResponseDto> findAll() throws CustomException {
        return issueService.findAll();
    }

    // 이슈 생성 api
    @PostMapping("/{userIdx}")
    @ApiOperation(value = "이슈 생성 API", notes = "유저 인덱스를 받아 해당 유저의 이슈 정보를 저장한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 201, message = "이슈 생성 성공"),
            @ApiResponse(code = 400, message = "잘못된 Request Body 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> createIssue(@PathVariable(name = "userIdx") Long userIdx, @RequestBody IssueRequestDto requestDto){
        return issueService.createIssue(userIdx, requestDto);
    }

    // 이슈 삭제
    @DeleteMapping("/{issueIdx}")
    @ApiOperation(value = "이슈 삭제 API", notes = "이슈 인덱스를 받아 해당 이슈 정보를 삭제한다.")
    @ApiImplicitParam(name = "issueIdx", value = "이슈 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 204, message = "이슈 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 이슈 인덱스 입력"),
            @ApiResponse(code = 404, message = "이슈 데이터 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> deleteIssue(@PathVariable(name = "issueIdx") Long issueIdx){
        return issueService.delete(issueIdx);
    }

    @PatchMapping("/{issueIdx}")
    @ApiOperation(value = "이슈 수정 API", notes = "이슈 인덱스를 받아 해당 이슈의 정보를 수정한다.")
    @ApiImplicitParam(name = "issueIdx", value = "이슈 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "이슈 수정 성공"),
            @ApiResponse(code = 400, message = "잘못된 이슈 정보 입력"),
            @ApiResponse(code = 404, message = "이슈 데이터 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> updateIssue(
            @PathVariable(name = "issueIdx") Long issueIdx,
            @RequestBody IssueRequestDto requestDto) throws CustomException {
        return issueService.updateIssue( issueIdx,requestDto);
    }

}
