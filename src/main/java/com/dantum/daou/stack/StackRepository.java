package com.dantum.daou.stack;

import com.dantum.daou.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StackRepository extends JpaRepository<Stack, Long> {
    List<Stack> findAllByUser(User user);
    Boolean existsByStack(String stack);
}
