package com.dantum.daou.Stack;

import com.dantum.daou.user.User;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name="stack")
public class Stack {
    @Id
    @Column(name="stack_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stackIdx;

    @NotNull
    @Column(name="stack")
    private String stack;

    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;
}
