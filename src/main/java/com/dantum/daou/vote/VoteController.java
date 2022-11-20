package com.dantum.daou.vote;


import com.dantum.daou.exception.CustomException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoteController {
    private final VoteService voteService;

    // 투표 리스트 조회
    @GetMapping("/votes/{userIdx}")
    @ApiOperation(value = "투표 목록 조회 API", notes = "유저 인덱스를 받아 해당 유저의 투표 목록을 조회한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "투표 목록 조회 성공"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public List<VoteResponseDto> findAll(){

        return voteService.findAll();
    }

    // 투표 상세 조회 api
    @GetMapping("/votes/details/{voteIdx}")
    @ApiOperation(value = "투표 상세 조회 API", notes = "투표 인덱스를 받아 해당 투표의 상세 정보를 수정한다.")
    @ApiImplicitParam(name = "voteIdx", value = "투표 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "투표 상세 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 투표 인덱스 입력"),
            @ApiResponse(code = 404, message = "투표 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> findVote(@PathVariable(name = "voteIdx") Long voteIdx) throws CustomException {
        return voteService.showResponse(voteIdx);
    }

    @PostMapping("/votes/{userIdx}")  // 투표 생성
    @ApiOperation(value = "투표 생성 API", notes = "유저 인덱스와 Request body를 받아 해당 투표를 생성한다.")
    @ApiImplicitParam(name = "userIdx", value = "유저 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 201, message = "투표 생성 성공"),
            @ApiResponse(code = 400, message = "잘못된 유저 인덱스 및 Request Body 입력"),
            @ApiResponse(code = 404, message = "유저 인덱스에 해당하는 유저 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> createVote(@PathVariable(name = "userIdx") Long userIdx, @RequestBody VoteRequestDto requestDto){
        return voteService.createVote(userIdx, requestDto);
    }

    // 투표 삭제
    @DeleteMapping("/votes/{voteIdx}")
    @ApiOperation(value = "투표 삭제 API", notes = "투표 인덱스를 받아 해당 투표를 삭제한다.")
    @ApiImplicitParam(name = "voteIdx", value = "투표 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 204, message = "투표 삭제 성공"),
            @ApiResponse(code = 400, message = "잘못된 투표 인덱스 입력"),
            @ApiResponse(code = 404, message = "투표 인덱스에 해당하는 투표 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> deleteVote(@PathVariable(name = "voteIdx") Long voteIdx){
        return voteService.delete(voteIdx);
    }

}
