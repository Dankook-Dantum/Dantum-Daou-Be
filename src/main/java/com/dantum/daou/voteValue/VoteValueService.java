package com.dantum.daou.voteValue;

import com.dantum.daou.exception.CustomException;
import com.dantum.daou.vote.Vote;
import com.dantum.daou.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dantum.daou.exception.ErrorCode.NOT_EXIST_VOTE;

@Service
@RequiredArgsConstructor
public class VoteValueService {
    private final VoteService voteService;
    private final VoteValueRepository voteValueRepository;

    @Transactional
    public ResponseEntity<Object> createVoteValue(VoteValueRequestDto requestDto) {
        Vote vote = voteService.findVote(requestDto.getVoteIdx());

        VoteValueCreateDto voteValueCreateDto = VoteValueCreateDto.builder()
                .requestDto(requestDto)
                .vote(vote).build();

        voteValueRepository.save(voteValueCreateDto.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED).body("Create Success");
    }

    @Transactional
    public ResponseEntity<Object> getVoteResult(Long voteIdx) throws CustomException {
        Vote vote = voteService.findVote(voteIdx);

        if (vote == null){
            throw new CustomException(NOT_EXIST_VOTE);
        }
        else {
            List<VoteValue> voteValueList = voteValueRepository.findByVote(vote);

            VoteValueResponseDto voteValueResponseDto = VoteValueResponseDto.builder()
                    .voteValueList(voteValueList).build();

            return ResponseEntity.status(HttpStatus.OK).body(voteValueResponseDto);
        }
    }
}
