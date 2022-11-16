package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import com.dantum.daou.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VoteService {

    private final UserRepository userRepository;
    private final VoteRepository voteRepository;

    private final VoteValueRepository voteValueRepository;

    @Transactional // 투표 생성
    public Long createVote(Long userIdx){
        User user = userRepository.findById(userIdx).orElseThrow(NullPointerException::new);
        return voteRepository.save(createRequestDto.toEntity()).getVoteIdx();
    }


    @Transactional(readOnly = true) // 투표 리스트 조회(예외처리 제외)
    public List<VoteResponseDto> findAll(){
        return voteRepository.findAll().stream()
                .map(VoteResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true) // 투표 상세 조회
    public Vote findVote(Long voteIdx){
         return voteRepository.findById(voteIdx)
                 .orElseThrow(NullPointerException::new);
    }

    @Transactional(readOnly = true)
    public List<VoteValue> findVoteValue(Vote vote){
        return voteValueRepository.findByVote(vote);
    }
}