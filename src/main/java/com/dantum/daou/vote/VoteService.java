package com.dantum.daou.vote;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Transactional
    public Long
}
