package com.dantum.daou.voteValue;

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
public class VoteValueController {
    private final VoteValueService voteValueService;

    @PostMapping("/votes/values")
    @ApiOperation(value = "투표하기 API", notes = "Request body를 받아 투표 정보를 저장한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "투표하기 성공"),
            @ApiResponse(code = 400, message = "잘못된 Request Body 입력"),
            @ApiResponse(code = 404, message = "투표 인덱스에 해당하는 투표가 없음"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> createVoteValue(@RequestBody VoteValueRequestDto requestDto) {
        return voteValueService.createVoteValue(requestDto);
    }

    @GetMapping("/votes/values/{voteIdx}")
    @ApiOperation(value = "투표 결과 조회 API", notes = "투표 인덱스를 받아 해당 투표의 결과를 조회한다.")
    @ApiImplicitParam(name = "voteIdx", value = "투표 인덱스로 int형의 양의 정수만 받는다", example = "1", dataType = "int")
    @ApiResponses({
            @ApiResponse(code = 200, message = "투표 결과 조회 성공"),
            @ApiResponse(code = 400, message = "잘못된 투표 인덱스 입력"),
            @ApiResponse(code = 500, message = "Server error")
    })
    public ResponseEntity<Object> getVoteResult(@PathVariable Long voteIdx) throws CustomException {
        return voteValueService.getVoteResult(voteIdx);
    }
}
