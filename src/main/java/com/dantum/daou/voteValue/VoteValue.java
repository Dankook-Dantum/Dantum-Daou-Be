package com.dantum.daou.voteValue;

import com.dantum.daou.stack.Stack;
import com.dantum.daou.user.User;
import com.dantum.daou.vote.Vote;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "voteValue")
public class VoteValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "votevalue_idx")
    private Long votevalueIdx;

    @Column(name = "type")
    private int type;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="vote_idx")
    private Vote vote;

    @Builder
    public VoteValue(int type,Vote vote){
        this.type = type;
        this.vote = vote;

    }
}
