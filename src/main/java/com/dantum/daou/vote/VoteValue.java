package com.dantum.daou.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "voteValue")
public class VoteValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "votevalue_idx")
    @NotNull
    private Long votevalueIdx;

    @Column(name = "type")
    private int type;


    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    // vote_idx 외래키 작성 필요

    @Builder
    public VoteValue(Long votevalueIdx, int type, LocalDateTime createdAt){
        this.votevalueIdx = votevalueIdx;
        this.type = type;
        this.createdAt = createdAt;

    }
}
