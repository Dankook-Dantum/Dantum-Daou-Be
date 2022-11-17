package com.dantum.daou.voteValue;

import com.dantum.daou.vote.Vote;
import com.dantum.daou.vote.VoteCreateDto;
import com.dantum.daou.vote.VoteRequestDto;
import com.dantum.daou.vote.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
