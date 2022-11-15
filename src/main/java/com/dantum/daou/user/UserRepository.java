package com.dantum.daou.user;

import com.dantum.daou.vote.VoteDetailResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
