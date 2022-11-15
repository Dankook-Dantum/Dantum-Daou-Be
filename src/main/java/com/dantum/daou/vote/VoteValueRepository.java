package com.dantum.daou.vote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VoteValueRepository extends JpaRepository<VoteValue, Long> {

    List<VoteValue> findByVote(Vote vote);
}
