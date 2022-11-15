package com.dantum.daou.vote;

import com.dantum.daou.user.User;
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
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_idx")
    @NotNull
    private Long voteIdx;

    @Column(name = "title")
    private String title;

    @Column(name = "type")

    private int type;

    @Column(name = "identifier")
    private int identifier;


    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    // user_idx 외래키 작성 필요
    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;

    @Builder
    public Vote(Long voteIdx, String title, int type, LocalDateTime createdAt,User user){
        this.voteIdx = voteIdx;
        this.title = title;
        this.type = type;
        this.createdAt = createdAt;
        this.user = user;
    }
}
