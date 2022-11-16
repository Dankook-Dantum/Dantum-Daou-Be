package com.dantum.daou.issue;


import com.dantum.daou.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @Column(name = "issue_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueIdx;


    // 이슈 제목
    @NotNull
    @Column(name = "title")
    private String title;

    // 이슈 내용
    @NotNull
    @Column(name = "content")
    private String content;

    // 이슈 라벨
    @NotNull
    @Column(name = "label")
    private String label;

    // user_idx : 외래키
    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;


    // 생성일

    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;
}
