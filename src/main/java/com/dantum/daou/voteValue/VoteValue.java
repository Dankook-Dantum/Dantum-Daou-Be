package com.dantum.daou.voteValue;

import com.dantum.daou.vote.Vote;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
