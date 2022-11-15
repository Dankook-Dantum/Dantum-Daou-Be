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
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_idx")
    @NotNull
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "type")
    private int type;

    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;


    // user_idx 외래키 작성 필요

    @Builder
    public Vote(Long id, String content, int type, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
