package com.dantum.daou.voteValue;

import com.dantum.daou.vote.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteValueRepository extends JpaRepository<VoteValue, Long> {

    List<VoteValue> findByVote(Vote vote);
}
