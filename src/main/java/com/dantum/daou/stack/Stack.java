package com.dantum.daou.stack;

import com.dantum.daou.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Builder;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;

    @Builder
    public Stack(String stack, User user) {
        this.stack = stack;
        this.user = user;
    }

    public void update(StackDto stackDto) {
        this.stack = stackDto.getStack();
    }
}
